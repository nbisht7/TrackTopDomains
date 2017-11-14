package com.bisht.track;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

import com.google.common.net.InternetDomainName;

/**
 * @author nbisht7. 
 *         Purpose - Implement a service that exposes a method that takes a URL as a 
 *                   parameter. The service then keeps a leaderboard count by domain 
 *                   for all the URLs that are passed to this method. The UI should 
 *                   show the 3 highest entries in the leaderboard at that given time. 
 *         Input   - URL. 
 *         Output  - A service which provides endpoint to accept the input URL and return 
 *                   the three highest referring domains.
 */

public class TrackURL {
	
	public String getURLCount(String urlString) throws IOException, URISyntaxException, ClassNotFoundException {

		String urlStringNew;
		String line = null;
		StringBuilder sb = null;
		Map<String, Integer> urlMap = new HashMap<String, Integer>();

		if (urlString!=null) {
			if (!urlString.startsWith("http://")) {
				urlStringNew = "http://" + urlString;
			} else {
				urlStringNew = urlString;
			}
		} else {
			return "URL cannot be empty";
		}

		URI uri = new URI(urlStringNew);

		// Fetching hostname from the URI
		String hostname = uri.getHost();
		InternetDomainName name = InternetDomainName.from(hostname).topPrivateDomain();

		String domain = name.toString();

		if (domain != null) {

			// Fetching only the domains from the URLs
			// That is given : www.xyz.com, get only : xyz.com
			String domainname = domain.startsWith("www.") ? domain.substring(4) : domain;

			// Storing the URLs entered by the user in a text file
			try (FileWriter fw = new FileWriter(
					"/Users/nehabisht/Downloads/SelfLearning/assignments/TrackingService/outputDir/urls.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw)) {
				out.write(domainname + " ");
				out.close();
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			sb = new StringBuilder();
			FileReader fr = new FileReader(
					"/Users/nehabisht/Downloads/SelfLearning/assignments/TrackingService/outputDir/urls.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					String tmp = st.nextToken().toLowerCase();
					// Populating the HashMap to store the domains as key and number of times those
					// were
					// entered as the values
					if (urlMap.containsKey(tmp)) {
						urlMap.put(tmp, urlMap.get(tmp) + 1);
					} else {
						urlMap.put(tmp, 1);
					}
				}
			}
			br.close();
			fr.close();

			// Making a set which has unique enteries of the domains
			Set<Entry<String, Integer>> urlSet = urlMap.entrySet();

			// Implementing own sorting logic
			ArrayList<Entry<String, Integer>> urlList = new ArrayList<Entry<String, Integer>>(urlSet);
			Collections.sort(urlList, new Comparator<Map.Entry<String, Integer>>() {
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return (o2.getValue()).compareTo(o1.getValue());
				}
			});

			// Displaying only top three URLs
			int count = 0;
			for (Map.Entry<String, Integer> entry : urlList) {
				if (count < 3) {
					sb.append((entry.getKey() + " => " + entry.getValue()));
				}
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "LeadershipBoard Count is:" + sb.toString();
	}
}
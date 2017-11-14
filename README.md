# TrackTopDomains
A service which provides endpoint to accept the input URLs and displays the three highest entered domains.

## Getting Started

Purpose : This is a service that exposes a method that takes a URL as a parameter and keeps a leaderboard count by domain for all the URLs that are passed to this method. And UI displays the 3 highest entries in the leaderboard at that given time. 

For instance : 

Input:

Service gets called 10 times in a row as follows:
 
Call 1: “www.facebook.com/user1/photos/index.html”

Call 2: “www.google.com/user1/photos/index.html”

Call 3: “www.yahoo.com”

Call 4: “www.google.com”

Call 5: “www.google.com/search/query/query.do”

Call 6: “store.apple.com/products/index.html”

Call 7: “www.apple.com/products/iphone/landingPage/index.html”

Call 8: “mail.google.com/user1/inbox.html”

Call 9: “mail.yahoo.com”

Call 10: “store.apple.com/product/macbook”

Output:

google.com: 4 , 
apple.com: 3 ,
yahoo.com: 2


### Prerequisites

Install below softwares: 

```
Java - 1.8
Tomcat - 8.5.23
```

### Installing

WIP

## Deployment

WIP

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

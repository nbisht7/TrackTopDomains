package com.bisht.track;

public class TrackURLProxy implements com.bisht.track.TrackURL {
  private String _endpoint = null;
  private com.bisht.track.TrackURL trackURL = null;
  
  public TrackURLProxy() {
    _initTrackURLProxy();
  }
  
  public TrackURLProxy(String endpoint) {
    _endpoint = endpoint;
    _initTrackURLProxy();
  }
  
  private void _initTrackURLProxy() {
    try {
      trackURL = (new com.bisht.track.TrackURLServiceLocator()).getTrackURL();
      if (trackURL != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)trackURL)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)trackURL)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (trackURL != null)
      ((javax.xml.rpc.Stub)trackURL)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bisht.track.TrackURL getTrackURL() {
    if (trackURL == null)
      _initTrackURLProxy();
    return trackURL;
  }
  
  public java.lang.String getURLCount(java.lang.String urlString) throws java.rmi.RemoteException{
    if (trackURL == null)
      _initTrackURLProxy();
    return trackURL.getURLCount(urlString);
  }
  
  
}
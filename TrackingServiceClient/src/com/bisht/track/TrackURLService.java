/**
 * TrackURLService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bisht.track;

public interface TrackURLService extends javax.xml.rpc.Service {
    public java.lang.String getTrackURLAddress();

    public com.bisht.track.TrackURL getTrackURL() throws javax.xml.rpc.ServiceException;

    public com.bisht.track.TrackURL getTrackURL(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

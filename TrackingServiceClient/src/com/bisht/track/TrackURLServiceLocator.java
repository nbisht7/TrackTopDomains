/**
 * TrackURLServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bisht.track;

public class TrackURLServiceLocator extends org.apache.axis.client.Service implements com.bisht.track.TrackURLService {

    public TrackURLServiceLocator() {
    }


    public TrackURLServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TrackURLServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TrackURL
    private java.lang.String TrackURL_address = "http://localhost:8080/TrackingService/services/TrackURL";

    public java.lang.String getTrackURLAddress() {
        return TrackURL_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TrackURLWSDDServiceName = "TrackURL";

    public java.lang.String getTrackURLWSDDServiceName() {
        return TrackURLWSDDServiceName;
    }

    public void setTrackURLWSDDServiceName(java.lang.String name) {
        TrackURLWSDDServiceName = name;
    }

    public com.bisht.track.TrackURL getTrackURL() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TrackURL_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTrackURL(endpoint);
    }

    public com.bisht.track.TrackURL getTrackURL(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bisht.track.TrackURLSoapBindingStub _stub = new com.bisht.track.TrackURLSoapBindingStub(portAddress, this);
            _stub.setPortName(getTrackURLWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTrackURLEndpointAddress(java.lang.String address) {
        TrackURL_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bisht.track.TrackURL.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bisht.track.TrackURLSoapBindingStub _stub = new com.bisht.track.TrackURLSoapBindingStub(new java.net.URL(TrackURL_address), this);
                _stub.setPortName(getTrackURLWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TrackURL".equals(inputPortName)) {
            return getTrackURL();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://track.bisht.com", "TrackURLService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://track.bisht.com", "TrackURL"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TrackURL".equals(portName)) {
            setTrackURLEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

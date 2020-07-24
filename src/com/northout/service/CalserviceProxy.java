package com.northout.service;

public class CalserviceProxy implements com.northout.service.Calservice {
  private String _endpoint = null;
  private com.northout.service.Calservice calservice = null;
  
  public CalserviceProxy() {
    _initCalserviceProxy();
  }
  
  public CalserviceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalserviceProxy();
  }
  
  private void _initCalserviceProxy() {
    try {
      calservice = (new com.northout.service.CalserviceServiceLocator()).getCalservice();
      if (calservice != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calservice)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calservice != null)
      ((javax.xml.rpc.Stub)calservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.northout.service.Calservice getCalservice() {
    if (calservice == null)
      _initCalserviceProxy();
    return calservice;
  }
  
  public int sub(int i, int j) throws java.rmi.RemoteException{
    if (calservice == null)
      _initCalserviceProxy();
    return calservice.sub(i, j);
  }
  
  public int add(int i, int j) throws java.rmi.RemoteException{
    if (calservice == null)
      _initCalserviceProxy();
    return calservice.add(i, j);
  }
  
  
}
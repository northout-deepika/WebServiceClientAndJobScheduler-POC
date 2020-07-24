/**
 * CalserviceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.northout.service;

public interface CalserviceService extends javax.xml.rpc.Service {
    public java.lang.String getCalserviceAddress();

    public com.northout.service.Calservice getCalservice() throws javax.xml.rpc.ServiceException;

    public com.northout.service.Calservice getCalservice(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

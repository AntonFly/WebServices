/**
 * PersonWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;

public interface PersonWebService extends java.rmi.Remote {
    public mypackage.User[] getPersonsByNameAndSurname(java.lang.String personName, java.lang.String personSurname) throws java.rmi.RemoteException;
    public mypackage.User[] getAllPersons() throws java.rmi.RemoteException;
    public mypackage.User[] getPersonsByName(java.lang.String personName) throws java.rmi.RemoteException;
    public mypackage.User[] getPersonsByPhone(java.lang.String personPhone) throws java.rmi.RemoteException;
    public mypackage.User[] getPersonsByEmail(java.lang.String personEmail) throws java.rmi.RemoteException;
}

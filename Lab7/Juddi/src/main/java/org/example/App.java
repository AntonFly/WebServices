package org.example;

import org.uddi.api_v3.ServiceInfos;
import org.uddi.api_v3.ServiceList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("To get some service type: get serviceName");
        System.out.println("To register some service type: register businessName serviceName serviceLocationURL");

        if (args.length < 1) {
            System.out.println("Parameters are missed");
            return;
        }
        if (args[0].equals("get")) {
            if (args.length != 2) {
                System.out.println("SERVICE NAME MISSED");
            } else {
                findService(args[1]);
            }
        }

        if (args[0].equals("register")) {
            if (args.length != 4) {
                System.out.println("ADDITIONAL PARAMETERS MISSED");
            } else {
                registerService(args[1], args[2], args[3]);
            }
        }
    }

    public static void registerService(String businessName, String serviceName, String serviceLocation) {
        SimplePublishPortable publishPortable = new SimplePublishPortable();
        publishPortable.publish(businessName, serviceName, serviceLocation);
    }

    //find service by name and print info
    public static void findService(String name) {
        SimpleBrowse simpleBrowse = new SimpleBrowse();
        ServiceList service = simpleBrowse.findServiceByName(name);
        ServiceInfos serviceInformation = service.getServiceInfos();
        System.out.println("SERVICE TO FIND: " + name);
        serviceInformation.getServiceInfo().forEach(serviceInfo -> {
            System.out.println("Service name: " + serviceInfo.getName().get(0).getValue());
            System.out.println("Service key: " + serviceInfo.getServiceKey());
            System.out.println("Business key: " + serviceInfo.getBusinessKey());
        });
        System.out.println();
    }
}

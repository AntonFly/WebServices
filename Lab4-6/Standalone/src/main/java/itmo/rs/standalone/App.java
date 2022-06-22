package itmo.rs.standalone;

import com.sun.jersey.api.core.PackagesResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.net.URI;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;


public class App {
    private static final URI BASE_URI =URI.create("http://localhost:8088/rest/");
    public static void main(String[] args) {
        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new
                    PackagesResourceConfig(PersonService.class.getPackage().getName());
            server = GrizzlyServerFactory.createHttpServer(BASE_URI,
                    resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }

    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}
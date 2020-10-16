package lk.ijse.webservice.resource_access;

import lk.ijse.webservice.resource_access.api.ResourceAccessRest;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class RestServer {
    private Server server;

    private static int getPort() {
        return Integer.parseInt(System.getenv().getOrDefault("PORT", "5000"));
    }

    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(getPort());
        server.setConnectors(new Connector[]{connector});

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(ResourceAccessRest.class, "/hello");
        server.start();
    }
}
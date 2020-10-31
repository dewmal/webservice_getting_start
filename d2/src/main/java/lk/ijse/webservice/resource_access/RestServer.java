package lk.ijse.webservice.resource_access;

import lk.ijse.webservice.resource_access.api.ResourceAccessRest;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SessionIdManager;
import org.eclipse.jetty.server.session.DefaultSessionIdManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class RestServer {
    private Server server;


    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        // Specify the Session ID Manager
        SessionIdManager idmanager = new DefaultSessionIdManager(server);
        server.setSessionIdManager(idmanager);

        SessionHandler sessions = new SessionHandler();
        sessions.setSessionIdManager(idmanager);

        ServletHandler servletHandler = new ServletHandler();
        sessions.setHandler(servletHandler);

        servletHandler.addServletWithMapping(ResourceAccessRest.class, "/hello");

        server.setHandler(sessions);



        server.start();
    }
}
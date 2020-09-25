### Prepare 

Add Jetty Library
```groovy


    compile group: 'org.eclipse.jetty', name: 'jetty-server', version: '9.4.31.v20200723'
    compile group: 'org.eclipse.jetty', name: 'jetty-servlet', version: '9.4.31.v20200723'

```


### Create First Servlet

Create Simple Web Service Class
```java


import javax.servlet.http.HttpServlet;

public class HelloWorldSimpleRest extends HttpServlet {
    
    
    
}

```

Create Web Service
```java


import javax.servlet.http.HttpServlet;

public class HelloWorldSimpleRest extends HttpServlet {
    
    protected void doGet(
                HttpServletRequest request,
                HttpServletResponse response)
                throws ServletException, IOException {
    
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("{ \"hello\": \"World\"}");
        }
    
}

```

Create Server

```java

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class RestServer {
    private Server server;

    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[]{connector});
    }
}

```

Add Rest Controller Into Server

```java

import lk.ijse.webservices.helloworld.rest.HelloWorldSimpleRest;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class RestServer {
    private Server server;

    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[]{connector});

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(HelloWorldSimpleRest.class, "/hello");
        server.start();
    }
}

```

Run server

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World Server Starting...");
        RestServer server = new RestServer();
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
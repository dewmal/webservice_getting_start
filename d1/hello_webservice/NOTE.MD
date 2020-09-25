### Create First Servlet

Create Simple Web Service Class
```java

package lk.ijse.webservices.helloworld.rest;

import javax.servlet.http.HttpServlet;

public class HelloWorldSimpleRest extends HttpServlet {
    
    
    
}

```

Create Web Service
```java

package lk.ijse.webservices.helloworld.rest;

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


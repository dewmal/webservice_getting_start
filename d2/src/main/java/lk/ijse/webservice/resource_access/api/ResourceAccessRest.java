package lk.ijse.webservice.resource_access.api;

import com.google.gson.Gson;
import lk.ijse.webservice.resource_access.modal.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ResourceAccessRest extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Message message = new Message("Test", "Message", new Date());
        Gson gson = new Gson();
        String json = gson.toJson(message);


        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(json);
    }

}
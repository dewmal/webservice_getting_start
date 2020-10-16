package lk.ijse.webservices.helloworld.rest;

import com.google.gson.Gson;
import lk.ijse.webservices.helloworld.resource.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

public class ResourceAccessRest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        Message message = new Message("Test Tile",
                "Test Message", new Date());

        Gson gson = new Gson();
        String messageJson = gson.toJson(message);


        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(messageJson);

    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            System.out.println(e);
        }

        String payloadString = jb.toString();

        Gson gson = new Gson();
        Message  message = gson.fromJson(payloadString,Message.class);

        System.out.println(message);


        resp.getWriter().println("OK");
    }
}

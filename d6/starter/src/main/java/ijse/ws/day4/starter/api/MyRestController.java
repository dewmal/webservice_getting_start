package ijse.ws.day4.starter.api;


import ijse.ws.day4.starter.data.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyRestController {

    @GetMapping("/api/hello")
    public Message greeting() {
        Message msg = new Message();
        msg.setSender("Server");
        msg.setMessage("Hello World");
        msg.setSentTime(new Date());
        return msg;
    }
}

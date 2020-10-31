package ijse.ws.day4.starter.api;


import ijse.ws.day4.starter.data.Message;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/message")
    public Message messageBuilder(
            @RequestParam("username")
                    String user,
            @RequestParam("message")
                    String message) {
        Message msg = new Message();
        msg.setSender(user);
        msg.setMessage(message);
        msg.setSentTime(new Date());
        return msg;
    }

    @RequestMapping(value = "/api/message", method = RequestMethod.POST)
    public Message createMessage(@RequestBody() Message message) {
        System.out.println(message);
        return message;
    }
}

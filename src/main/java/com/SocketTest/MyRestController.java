package com.SocketTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SocketTest.WebConfig.MyWebSocketHandler;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private MyWebSocketHandler webSocketHandler;

    @GetMapping("/send-message")
    public String sendMessageToWebSocket() {
        // Send a custom message with options
        String message = "Do you know him?";
        webSocketHandler.sendMessageWithOptions(message);
        return "Message sent to WebSocket!";
    }

}
/*
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.SocketTest.WebConfig.MyWebSocketHandler;
 * 
 * @RestController
 * 
 * @RequestMapping("/api") public class MyRestController {
 * 
 * @Autowired private MyWebSocketHandler webSocketHandler;
 * 
 * @GetMapping("/send-message") public String sendMessageToWebSocket() { // Send
 * a custom message with options String message = "Do you know him?";
 * webSocketHandler.sendMessageWithOptions(message); return
 * "Message sent to WebSocket!"; } }
 * 
 */
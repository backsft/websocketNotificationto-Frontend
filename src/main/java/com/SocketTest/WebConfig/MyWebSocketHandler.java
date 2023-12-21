package com.SocketTest.WebConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    private static final List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        // Check message type and handle accordingly
        if (payload.equals("Yes:Friend")) {
            // Handle friend option
            session.sendMessage(new TextMessage("You selected: Friend"));
        } else if (payload.equals("Yes:Family")) {
            // Handle family option
            session.sendMessage(new TextMessage("You selected: Family"));
        } else {
            // Handle other messages (e.g., "No")
            session.sendMessage(new TextMessage("Notification dismissed"));
        }
    }

    public static void sendMessageWithOptions(String message) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

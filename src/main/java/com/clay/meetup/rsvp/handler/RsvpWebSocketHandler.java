package com.clay.meetup.rsvp.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class RsvpWebSocketHandler extends AbstractWebSocketHandler {

    @Override
    public void handleMessage(
            WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(message.getPayload());
    }
}

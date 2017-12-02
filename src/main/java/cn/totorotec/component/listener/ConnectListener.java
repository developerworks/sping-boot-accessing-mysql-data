package cn.totorotec.component.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.security.Principal;

public class ConnectListener implements ApplicationListener<SessionConnectedEvent> {


    private SimpMessageSendingOperations messagingTemplate;


    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        MessageHeaders headers = event.getMessage().getHeaders();
        Principal user = SimpMessageHeaderAccessor.getUser(headers);
        if (user == null) {
            return;
        }
        String id = SimpMessageHeaderAccessor.getSessionId(headers);

    }
}

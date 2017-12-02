package cn.totorotec.websocket;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);
    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping
    public void processMessageFromClient(@Payload String message, SimpMessageHeaderAccessor simpMessageHeaderAccessor) throws  Exception {
        String sessionId = simpMessageHeaderAccessor.getSessionAttributes().get("sessionId").toString();
        logger.info("WebSocketController sessionId: ", sessionId);
        simpMessageHeaderAccessor.setSessionId(sessionId);
        simpMessageSendingOperations.convertAndSend("/topic/replly", new Gson().fromJson(message, Map.class).get("name"));
    }
}

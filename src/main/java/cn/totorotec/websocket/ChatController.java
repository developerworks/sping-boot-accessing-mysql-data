/**
 * Building a chat application with Spring Boot and WebSocket
 * <p>
 * https://www.callicoder.com/spring-boot-websocket-chat-example/
 */

package cn.totorotec.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    /**
     * /app/chat-send-message
     *
     * @param chatMessage
     * @return
     */
    @MessageMapping("/chat-send-message")
    @SendTo("/channel/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    /**
     * /app/chat-add-user
     *
     * @param chatMessage
     * @param simpMessageHeaderAccessor
     * @return
     */
    @MessageMapping("/chat-add-user")
    @SendTo("/channel/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor simpMessageHeaderAccessor) {
        // 添加用户名到 WebSocket 会话
        simpMessageHeaderAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}

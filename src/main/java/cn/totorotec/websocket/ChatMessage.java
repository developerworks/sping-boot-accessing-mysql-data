package cn.totorotec.websocket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    /**
     * 消息类型枚举
     */
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    /**
     * 消息类型
     */
    private MessageType messageType;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息发送者
     */
    private String sender;

}

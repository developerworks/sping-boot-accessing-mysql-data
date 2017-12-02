package cn.totorotec.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.ExpiringSession;
import org.springframework.session.web.socket.config.annotation.AbstractSessionWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableScheduling
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractSessionWebSocketMessageBrokerConfigurer<ExpiringSession> {
    @Autowired
    private HttpHandshakeInterceptor httpHandshakeInterceptor;

    @Override
    protected void configureStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
        registry.addEndpoint("/messages-http-handshake").addInterceptors(httpHandshakeInterceptor);
    }

//    /**
//     * 注册端点
//     *
//     * 1. 注册 WebSocket 端点, 客户端可通过该端点连接到 WebSocket 服务器.
//     * 2. 使用 SockJS 支持那些没有 WebSocket 实现的浏览器.
//     *
//     * @param registry
//     */
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").withSockJS();
//        registry.addEndpoint("/messages-http-handshake").addInterceptors(httpHandshakeInterceptor);
//    }

    /**
     * 在客户端之间路由消息
     * <p>
     * 默认使用内存消息代理, 也可以使用 RabbitMQ, ActiveMQ 等消息队列服务器作为消息代理
     *
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/queue", "/topic", "/channel");
        registry.setApplicationDestinationPrefixes("/app");
    }
}

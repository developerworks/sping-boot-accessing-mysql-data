package cn.totorotec.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class HttpHandshakeInterceptor implements HandshakeInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(HttpHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(
        ServerHttpRequest request,
        ServerHttpResponse response,
        WebSocketHandler wsHandler,
        Map<String, Object> attributes
    ) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession();
            logger.info("Session create time: ", session.getCreationTime());
            logger.info("Session last access time: ", session.getLastAccessedTime());
            logger.info("Session attribute names: ", session.getAttributeNames());
            attributes.put("sessionId", session.getId());
        }
        return true;
    }

    public void afterHandshake(
        ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex
    ) {
        logger.info("HttpHandshakeInterceptor afterHandshake");
    }
}

package cn.totorotec.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.stereotype.Component;

@Component
public class SecurityEventListener implements ApplicationListener<AbstractAuthenticationEvent> {
    private static final Logger logger = LoggerFactory.getLogger(SecurityEventListener.class);

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        logger.info("Event is {}", event.getClass().getCanonicalName());
    }
}

/**
 * https://www.cnblogs.com/lfjjava/p/6096884.html
 * http://www.jianshu.com/p/8e603181adc1
 */
package cn.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hello")
@Component
public class HelloProperties {
    private static  final Logger logger = LoggerFactory.getLogger(HelloProperties.class);
    private String msg = "default";

    public String getMsg() {
        logger.info("如何进行自动配置?" + msg);

        return msg;
    }

    public void setMsg(String msg) {
        logger.info("如何进行自动配置?" + msg);

        this.msg = msg;
    }
}

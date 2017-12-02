/**
 * https://docs.spring.io/spring-session/docs/current/reference/html5/guides/hazelcast-spring.html#servlet-container-initialization
 *
 * Servlet Container Initialization
 *
 * =================================
 *        Servlet 容器初始化
 * =================================
 *
 * Our Spring Configuration created a Spring Bean named springSessionRepositoryFilter that implements Filter.
 * The springSessionRepositoryFilter bean is responsible for replacing the HttpSession with a custom implementation
 * that is backed by Spring Session.
 *
 * Spring 配置创建了一个名为 springSessionRepositoryFilter 的过滤器, 该过滤器负责用自定义后端的 Spring Session 实现去替换
 * HttpSession
 *
 * 然后需要保证 Servlet 容器使用 springSessionRepositoryFilter 过滤器来处理每一个请求.
 */
package cn.totorotec.config;

//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
//
//    public SecurityInitializer() {
//        super(SecurityConfig.class, JdbcSessionConfig.class);
//    }
//}

public class SecurityInitializer {

}



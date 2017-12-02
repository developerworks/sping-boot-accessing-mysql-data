/**
 * @EnableHazelcastHttpSession 注解创建一个名称为 springSessionRepositoryFilter 的Bean. 该过滤器 Bean 负责用 Spring Session
 * 实现去替换 HttpSession 实现
 */
package cn.totorotec.session.hazelcast;
//
//import com.hazelcast.config.Config;
//import com.hazelcast.config.MapAttributeConfig;
//import com.hazelcast.config.MapIndexConfig;
//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.session.hazelcast.HazelcastSessionRepository;
//import org.springframework.session.hazelcast.PrincipalNameExtractor;
//import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

//@Configuration
//@EnableHazelcastHttpSession
public class HazelcastHttpSessionConfig {
//
//    @Bean
//    public HazelcastInstance hazelcastInstance() {
//        MapAttributeConfig mapAttributeConfig = new MapAttributeConfig()
//            .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
//            .setExtractor(PrincipalNameExtractor.class.getName());
//
//        Config config = new Config();
//        config.getMapConfig("spring:session:sessions")
//            .addMapAttributeConfig(mapAttributeConfig)
//            .addMapIndexConfig(new MapIndexConfig(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));
//
//        return Hazelcast.newHazelcastInstance(config);
//
//    }
}

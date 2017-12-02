package cn.totorotec.config;


import com.hazelcast.config.Config;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
//
//@EnableHazelcastHttpSession(maxInactiveIntervalInSeconds = 300)
//@Configuration

@EnableJdbcHttpSession
public class JdbcSessionConfig {
//
//    @Bean(destroyMethod = "shutdown")
//    public HazelcastInstance hazelcastInstance() {
//        Config config = new Config();
//
//        int port = SocketUtils.findAvailableTcpPort();
//
//        config.getNetworkConfig()
//            .setPort(port);
//
//        System.out.println("Hazelcast port #: " + port);
//
//        SerializerConfig serializer = new SerializerConfig()
//            .setImplementation(new ObjectStreamSerializer())
//            .setTypeClass(Object.class);
//
//        config.getSerializationConfig()
//            .addSerializerConfig(serializer);
//
//        MapAttributeConfig attributeConfig = new MapAttributeConfig()
//            .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
//            .setExtractor(PrincipalNameExtractor.class.getName());
//
//        config.getMapConfig("spring:session:sessions")
//            .addMapAttributeConfig(attributeConfig)
//            .addMapIndexConfig(new MapIndexConfig(
//                HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));
//
//        return Hazelcast.newHazelcastInstance(config);
//    }
//
}

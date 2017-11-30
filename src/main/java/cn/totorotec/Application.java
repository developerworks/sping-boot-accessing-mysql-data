/**
 * @SpringBootApplication 做三件事:
 * <p>
 * - @SpringBootConfiguration
 * - @ComponentScan
 * - @EnableAutoConfiguration
 * <p>
 * <p>
 * ## @ComponentScan 扫描指定包, 以及子包中的所有组件
 * <p>
 * 所谓组件就是以下列Annotation 标注的类
 * <p>
 * - @Repository
 * - @Configuration
 * - @Controller
 * - @Service
 * - @RestController
 * - @Component
 * - @Bean
 */

package cn.totorotec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("cn.totorotec.entity")
@EnableJpaRepositories("cn.totorotec.repository")
@EnableTransactionManagement

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        logger.info("事务管理器实现类: " + platformTransactionManager.getClass().getName());
        return new Object();
    }

}

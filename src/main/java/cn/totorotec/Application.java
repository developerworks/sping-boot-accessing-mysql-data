/**
 * @SpringBootApplication 做三件事:
 *
 * - @SpringBootConfiguration
 * - @ComponentScan
 * - @EnableAutoConfiguration
 *
 *
 * ## @ComponentScan 扫描指定包, 以及子包中的所有组件
 *
 * 所谓组件就是以下列Annotation 标注的类
 *
 * - @Repository
 * - @Configuration
 * - @Controller
 * - @Service
 * - @RestController
 * - @Component
 * - @Bean
 */

package cn.totorotec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("cn.totorotec.entity")
@EnableJpaRepositories("cn.totorotec.repository")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

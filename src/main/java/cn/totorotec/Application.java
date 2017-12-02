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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Arrays;

@SpringBootApplication
@EntityScan("cn.totorotec.entity")
@EnableJpaRepositories("cn.totorotec.repository")
@EnableTransactionManagement
//@EnableGlobalMethodSecurity(jsr250Enabled = true)

/**
 * http://blog.csdn.net/code__code/article/details/53886912
 */
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * TODO::QUESTION
     */
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        logger.info("事务管理器实现类: " + platformTransactionManager.getClass().getName());
        return new Object();
    }

    /**
     * TODO:: 自动存储代码中声明的资源路径
     */
//    public void detectHandlerMethods() {
//        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
//        Set<RequestMappingInfo> mappings = map.keySet();
//        Map<String, String> reversedMap = new HashMap<String, String>();
//        for (RequestMappingInfo info : mappings) {
//            HandlerMethod method = map.get(info);
//            String methodstr = method.toString();
//            methodstr = methodstr.split("\\(")[0];
//            methodstr = methodstr.split(" ")[2];
//            int i = methodstr.lastIndexOf(".");
//            methodstr = methodstr.substring(0, i);
//            String urlparm = info.getPatternsCondition().toString();
//            String url = urlparm.substring(1, urlparm.length() - 1);
////            List<SysResource> list = sresourceService.findByResourceString(url);
////            if(list==null || list.size()<=0){
////                int num = (int)(Math.random()*100+1);
////                String rand = String.valueOf(num);
////                String resourceId = "res"+System.currentTimeMillis()+rand;
////                SysResource sysresource = new SysResource();
////                sysresource.setResourceString(url);
////                sysresource.setRemark("0");
////                sysresource.setResourceId(resourceId);
////                sysresource.setMethodPath(methodstr);
////                sresourceService.save(sysresource);
////                System.out.println ("===>"+url);
////            }
//
//        }
//    }

    /**
     * There is also a CommandLineRunner method marked as a @Bean and this runs on start up.
     * It retrieves all the beans that were created either by your app or were automatically added thanks to Spring Boot.
     * It sorts them and prints them out.
     *
     * CommandLineRunner 方法标记为 @Bean, 并且在启动时运行. 它获取所有由应用程序, 或Spring Boot自动添加的Bean, 排序并在控制台中打印.
     *
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            logger.info("==================== Let's inspect the beans provided by Spring Boot ======================:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                logger.info(beanName);
            }

        };
    }

}

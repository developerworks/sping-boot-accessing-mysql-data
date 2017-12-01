package cn.example;

import cn.totorotec.pojo.UrlMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http://breezylee.iteye.com/blog/2160876
 */

@RestController
public class Url2ControllerUtils {

    private static final Logger logger = LoggerFactory.getLogger(Url2ControllerUtils.class);

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping(path = "/url-mappings")
    @ResponseBody
    public List<UrlMapping> getUrlMappings(HttpServletResponse response) {

//        StringBuilder sb = new StringBuilder();
//        sb.append("URL").append("--").append("Class").append("--").append("Function").append('\n');
//
        List<UrlMapping> mappingList = new ArrayList<UrlMapping>();

        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
//            sb.append(info.getPatternsCondition()).append("--");
//            sb.append(method.getMethod().getDeclaringClass()).append("--");
//            sb.append(method.getMethod().getName()).append('\n');

            UrlMapping urlMapping = new UrlMapping();
            urlMapping.setUrl(info.getPatternsCondition().toString());
            urlMapping.setClassname(method.getMethod().getDeclaringClass().toString());
            urlMapping.setMethod(method.getMethod().getName());

            mappingList.add(urlMapping);
        }
//        logger.info(sb.toString());

        return mappingList;
    }
}

package cn.totorotec.controller;

import cn.totorotec.entity.User;
import cn.totorotec.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PropertyResourceBundle;
import java.util.Set;

@Controller
//@RestController
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(path = "/add")
    @Transactional
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) throws IOException {

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        // 创建验证器工程
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        // 实例化验证器
        Validator validator = factory.getValidator();

        // 验证并获取验证结果
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        // TODO:资源文件在应用程序启动的时候加载并且常驻内存, 适合小文件

        // 检查错误
        if (violations.size() == 0) {
            userRepository.save(user);
            return "Saved.";
        }
        // 获取错误提示
        else {
            StringBuffer buf = new StringBuffer();
            InputStream utf8in = getClass().getClassLoader().getResourceAsStream("messages_zh_CN.properties");
            PropertyResourceBundle bundle = new PropertyResourceBundle(new InputStreamReader(utf8in, "UTF-8"));
            for (ConstraintViolation<User> violation : violations) {
                buf.append("-" + bundle.getString(violation.getPropertyPath().toString()));
                buf.append(violation.getMessage() + "\n");
            }
            System.out.println(buf);
            return "Save error.";
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}

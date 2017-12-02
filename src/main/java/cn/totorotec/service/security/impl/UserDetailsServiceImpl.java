/**
 * 自动装配 UserService 和 Converter, 覆盖 loadUserByUsername() 方法, 把 User 转换为一个 UserDetails
 */
package cn.totorotec.service.security.impl;

import cn.totorotec.entity.User;
import cn.totorotec.service.db.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@Getter
@Setter

public class UserDetailsServiceImpl {

}

//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    @Qualifier(value = "userToUserDetails")
//    private Converter<User, UserDetails> userUserDetailsConverter;
//
//    /**
//     * 获取用户信息
//     *
//     * @param username
//     * @return
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User name " + username + " not found");
//        }
//        return userUserDetailsConverter.convert(user);
//    }
//}

package cn.totorotec.converters;

//import cn.totorotec.entity.User;
//import cn.totorotec.service.security.impl.UserDetailsImpl;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// * 类型转换器
// * <p>
// * 把源类型S(Source), 转换为目标类型T(Target)
// */
//
//@Component
//public class UserToUserDetails implements Converter<User, UserDetails> {
//    @Override
//    public UserDetails convert(User user) {
//        UserDetailsImpl userDetails = new UserDetailsImpl();
//        if (user != null) {
//            // 用户名称
//            userDetails.setUsername(user.getUsername());
//
//            // 密码密文
//            userDetails.setPassword(user.getEncryptedPassword());
//
//            // 是否启用
//            userDetails.setEnabled(user.getEnabled());
//
//            // 职权列表
//            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//            // 获取每一个角色
//            user.getRoles().forEach(role -> {
//                authorities.add(new SimpleGrantedAuthority(role.getName()));
//            });
//            // 设置
//            userDetails.setAuthorities(authorities);
//        }
//
//        return userDetails;
//    }
//}

public class UserToUserDetails {

}

package cn.totorotec.service.security.impl;

import cn.totorotec.entity.Permission;
import cn.totorotec.entity.Role;
import cn.totorotec.repository.RoleRepository;
import cn.totorotec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
public class MyUserDetailsService {

}
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return null;
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
//
//        return getGrantedAuthorities(getPermissions(roles));
//    }
//
//    private List<String> getPermissions(Collection<Role> roles) {
//
//        List<String> Permissions = new ArrayList<String>();
//        List<Permission> collection = new ArrayList<Permission>();
//        for (Role role : roles) {
//            collection.addAll(role.getPermissions());
//        }
//        for (Permission item : collection) {
//            Permissions.add(item.getName());
//        }
//        return Permissions;
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(List<String> Permissions) {
//        List<GrantedAuthority> authorities = new ArrayList<UserDetailsServiceImpl>();
//        for (String Permission : Permissions) {
//            authorities.add(new SimpleGrantedAuthority(Permission));
//        }
//        return authorities;
//    }
//}

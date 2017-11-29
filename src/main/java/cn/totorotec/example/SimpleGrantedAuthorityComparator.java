package cn.totorotec.example;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Comparator;

public class SimpleGrantedAuthorityComparator implements Comparator<SimpleGrantedAuthority> {
    @Override
    public int compare(SimpleGrantedAuthority o1, SimpleGrantedAuthority o2) {
//        return 0;
        return o1.equals(o2) ? 0 : -1;
    }
}

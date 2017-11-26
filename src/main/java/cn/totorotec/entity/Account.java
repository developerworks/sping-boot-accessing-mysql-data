package cn.totorotec.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Account extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String username;

    @Column
    private String hash_password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }


}

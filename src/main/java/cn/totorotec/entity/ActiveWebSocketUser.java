package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity
@Getter
@Setter
public class ActiveWebSocketUser extends AbstractEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 连接事件
     */
    private Calendar connectionTime;

    public ActiveWebSocketUser() {
    }

    public ActiveWebSocketUser(Long id, String username, Calendar connectionTime) {
        super();
        this.setId(id);
        this.username = username;
        this.connectionTime = connectionTime;
    }
}

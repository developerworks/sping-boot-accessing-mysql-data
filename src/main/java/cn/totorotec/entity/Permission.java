package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Permission extends AbstractEntity {
    private String name;
}

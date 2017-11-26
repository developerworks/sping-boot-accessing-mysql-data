package cn.totorotec.entity;

import javax.persistence.Entity;

@Entity
public class Role extends AbstractEntity {
    private String name;
    private String description;
}

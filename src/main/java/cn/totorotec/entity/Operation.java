package cn.totorotec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Operation extends AbstractEntity {
    private String name;
    private String description;

    public Operation() {
    }

    public Operation(String name) {
        this.name = name;
    }

    public Operation(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

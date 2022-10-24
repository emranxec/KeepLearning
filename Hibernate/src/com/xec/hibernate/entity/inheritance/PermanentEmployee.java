package com.xec.hibernate.entity.inheritance;
import javax.persistence.*;

@Entity
@Table(name="PERMANENT_EMPLOYEE")
@DiscriminatorValue("PERMANENT_EMP")
public class PermanentEmployee extends Employee {

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
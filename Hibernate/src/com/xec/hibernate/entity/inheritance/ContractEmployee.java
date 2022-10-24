package com.xec.hibernate.entity.inheritance;
import javax.persistence.*;

@Entity
@Table(name="CONTRACT_EMPLOYEE")
@DiscriminatorValue("CONTRACT_EMP")
public class ContractEmployee extends Employee {

    @Column(name = "TYPE")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
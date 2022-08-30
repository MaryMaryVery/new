package org.itstep.helloworldspring;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Constraint;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Owner")
public class Owner {


    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Owner_id;
    private String Owner_name;
    private String phone;
    private String city;
    Constraint PK_Owner;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "Dog_Id")

    public Long getOwner_id() {
        return Owner_id;
    }

    public String getOwner_name() {
        return Owner_name;
    }

    public void setOwner_name(String owner_name) {
        Owner_name = owner_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Constraint getPK_Owner() {
        return PK_Owner;
    }

    public void setPK_Owner(Constraint PK_Owner) {
        this.PK_Owner = PK_Owner;
    }
}





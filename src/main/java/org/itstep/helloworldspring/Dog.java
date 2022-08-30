package org.itstep.helloworldspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dog")
public class Dog {

    @Id
    @Column(name = "Dog_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Dog_Id;
    private String Nickname;





}

package com.edureka.spring1.secureapi.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity // if not @Table annotation hibernate picks a default table name user. same with @Column
public class UserAccount {

    public UserAccount(String username,String password,boolean active){

        this.active = active;
        this.username = username;
        this.password = password;

    }
    @Id
    @GeneratedValue
    private int id;
  //  @Column(name="user_name")
    private String username;
   // @Column(name="password")
    private String password;
   // @Column(name="active")
    private boolean active;

}

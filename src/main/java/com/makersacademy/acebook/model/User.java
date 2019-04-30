package com.makersacademy.acebook.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "auth_user")
public class User {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="auth_user_auth_user_id_seq")
    private Long auth_user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String status;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
//    private Set<Role> roles;

    public Long getId() {
        return auth_user_id;
    }

    public void setId(Long auth_user_id) {
        this.auth_user_id = auth_user_id;
    }

    public String getName() {
        return first_name;
    }
    public void setName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

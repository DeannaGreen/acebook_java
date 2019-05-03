package com.makersacademy.acebook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "LIKES")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    private Long like_id;
    @Column(name = "auth_user_id")
    private Long user_id;


    private Likes() {

    }

    public Likes(Long post_id, Long user_id) {

        this.post_id = post_id;
        this.user_id = user_id;

    }

}

package com.makersacademy.acebook.model;


import javax.persistence.*;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String timestamp;
    @Column(name = "post_id", nullable = false)
    public Long postid;

    private Comment() {}

    public Comment(String content, Long post_id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.timestamp = dtf.format(now);

        this.content = content;
        this.postid = post_id;
    }


}

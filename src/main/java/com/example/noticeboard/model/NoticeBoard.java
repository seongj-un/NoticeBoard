package com.example.noticeboard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }



}

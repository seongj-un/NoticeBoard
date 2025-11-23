package com.example.noticeboard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<NoticeBoard> noticeBoards = new ArrayList<>();


    public void Update(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addNoticeBoard(NoticeBoard noticeBoard) {
        noticeBoards.add(noticeBoard);
        noticeBoard.setUser(this);  // NoticeBoard.user 필드 세팅
    }
}

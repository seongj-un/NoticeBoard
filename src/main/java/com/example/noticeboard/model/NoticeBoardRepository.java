package com.example.noticeboard.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Integer> {
}

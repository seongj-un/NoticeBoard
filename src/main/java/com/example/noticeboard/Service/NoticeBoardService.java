package com.example.noticeboard.Service;

import com.example.noticeboard.model.NoticeBoard;
import com.example.noticeboard.model.NoticeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;

    public NoticeBoard createNorticeBoard(String title, String content) {
        NoticeBoard noticeBoard = NoticeBoard.builder()
                .title(title)
                .content(content)
                .build();

        return noticeBoardRepository.save(noticeBoard);
    }

    public List<NoticeBoard> getAllNorticeBoards() {
        return noticeBoardRepository.findAll();
    }

    public NoticeBoard getNorticeBoardById(Integer id) {
        return noticeBoardRepository.getById(id);
    }

    public NoticeBoard updateNorticeBoard(int id, String title, String content) {
        NoticeBoard noticeBoard = noticeBoardRepository.findById(id).orElse(null);
        noticeBoard.update(title, content);
        return noticeBoardRepository.save(noticeBoard);
    }

    public boolean deleteNorticeBoard(int id) {
        if(noticeBoardRepository.existsById(id)) {
            noticeBoardRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

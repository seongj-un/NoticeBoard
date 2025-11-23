package com.example.noticeboard.Service;

import com.example.noticeboard.model.NoticeBoard;
import com.example.noticeboard.model.NoticeBoardRepository;
import com.example.noticeboard.model.User;
import com.example.noticeboard.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;
    private final UserRepository userRepository;

    public NoticeBoard createNorticeBoard(Long user_id,String title, String content) {
        User user = userRepository.findById(user_id).orElse(null);

        NoticeBoard noticeBoard = NoticeBoard.builder()
                .title(title)
                .content(content)
                .user(user)
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

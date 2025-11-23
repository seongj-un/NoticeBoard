package com.example.noticeboard.controllor;

import com.example.noticeboard.dto.CreatNoticeBoardRequest;
import com.example.noticeboard.model.NoticeBoard;
import com.example.noticeboard.Service.NoticeBoardService;
import com.example.noticeboard.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/notice")
@RequiredArgsConstructor
@RestController
public class NoticeBoardControlloer {
    //controller service model repository==db랑 연결되어 잇는 애임

    private final NoticeBoardService nRService;

    @PostMapping("/{user_id}")
    public NoticeBoard createNorticeBoard(@PathVariable Long user_id ,@RequestBody CreatNoticeBoardRequest dto) {
        return nRService.createNorticeBoard(user_id,dto.getTitle(), dto.getContent());
    }

    @GetMapping
    public List<NoticeBoard> getAllNotices() {
        return nRService.getAllNorticeBoards();
    }

    @GetMapping("/{id}")
    public NoticeBoard getNorticeBoardById(@PathVariable int id) {
        return nRService.getNorticeBoardById(id);
    }

    @PutMapping("/{id}")
    public NoticeBoard updateNortice(@PathVariable int id, @RequestBody CreatNoticeBoardRequest dto) {
        return nRService.updateNorticeBoard(id, dto.getTitle(), dto.getContent());
    }


    @DeleteMapping("/{id}")
    public String deleteNorticeBoard(@PathVariable int id) {
        boolean deleted = nRService.deleteNorticeBoard(id);
        return deleted ? "삭제 성공" : "삭제 실패: 해당 ID 없음";
    }


}


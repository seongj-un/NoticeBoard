package com.example.noticeboard.controllor;

import com.example.noticeboard.dto.CreatNorticeBoardRequest;
import com.example.noticeboard.model.NorticeBoard;
import com.example.noticeboard.model.NorticeBoardRepository;
import com.example.noticeboard.Service.NRService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NBControlloer {

    private final NRService nRService;
    private final NorticeBoardRepository norticeBoardRepository; // Repository 주입

    @PostMapping
    public NorticeBoard createNorticeBoard(@RequestBody CreatNorticeBoardRequest dto) {
        return nRService.createNorticeBoard(dto.getTitle(), dto.getContent());
    }

    @GetMapping
    public List<NorticeBoard> getAllNotices() {
        return norticeBoardRepository.findAll(); // 주입된 Repository 사용
    }

    @GetMapping("/{id}")
    public NorticeBoard getNorticeBoardById(@PathVariable int id) {
        return norticeBoardRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public NorticeBoard updateNortice(@PathVariable int id, @RequestBody CreatNorticeBoardRequest dto) {
        return nRService.updateNorticeBoard(id, dto.getTitle(), dto.getContent());
    }


    @DeleteMapping("/{id}")
    public String deleteNorticeBoard(@PathVariable int id) {
        boolean deleted = nRService.deleteNorticeBoard(id);
        return deleted ? "삭제 성공" : "삭제 실패: 해당 ID 없음";
    }


}


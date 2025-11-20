package com.example.noticeboard.Service;

import com.example.noticeboard.model.NorticeBoard;
import com.example.noticeboard.model.NorticeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequiredArgsConstructor
@Service
public class NRService {

    private final NorticeBoardRepository norticeBoardRepository;

    public NorticeBoard createNorticeBoard(String title, String content) {
        NorticeBoard norticeBoard1 = NorticeBoard.builder()
                .title(title)
                .content(content)
                .build();

        return norticeBoardRepository.save(norticeBoard1);
    }

    public NorticeBoard updateNorticeBoard(int id, String title, String content) {
        NorticeBoard norticeBoard = norticeBoardRepository.findById(id).orElse(null);
        norticeBoard.update(title, content);
        return norticeBoardRepository.save(norticeBoard);
    }

    public boolean deleteNorticeBoard(int id) {
        if(norticeBoardRepository.existsById(id)) {
            norticeBoardRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

package com.example.noticeboard.Service;

import com.example.noticeboard.model.NorticeBoard;
import com.example.noticeboard.model.NorticeBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

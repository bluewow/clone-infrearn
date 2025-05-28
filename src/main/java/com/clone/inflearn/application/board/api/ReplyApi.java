package com.clone.inflearn.application.board.api;

import com.clone.inflearn.application.board.dto.ReplyRequest;
import com.clone.inflearn.application.board.facade.ReplyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReplyApi {
    private final ReplyFacade replyFacade;

    @PostMapping("/reply")
    public void createReply(@RequestBody ReplyRequest request) {
        replyFacade.createReply(request);
    }

}

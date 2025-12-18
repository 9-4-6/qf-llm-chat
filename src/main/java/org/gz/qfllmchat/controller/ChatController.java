package org.gz.qfllmchat.controller;
import org.gz.qfllmchat.service.Assistant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author guozhong
 * @date 2025/12/10
 * @description 聊天
 */
@RestController("/chat")
public class ChatController {

    private final Assistant assistant;
    public ChatController(Assistant assistant){
     this.assistant = assistant;
    }
    @GetMapping(value = "/stream-chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChat(@RequestParam String message) {
        return assistant.streamChat(message);
    }
}

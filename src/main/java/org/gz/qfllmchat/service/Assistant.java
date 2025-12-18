package org.gz.qfllmchat.service;

import reactor.core.publisher.Flux;

/**
 * @author guozhong
 * @date 2025/12/18
 * @description TODO
 */
public interface Assistant {
     String chat(String msg);

     Flux<String> streamChat(String message);

}

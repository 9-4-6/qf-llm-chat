package org.gz.qfllmchat.config;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.service.AiServices;
import org.gz.qfllmchat.service.Assistant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guozhong
 * @date 2025/12/10
 * @description langChain配置
 */
@Configuration
public class LangChainConfig {


    @Bean
    public OllamaChatModel getOllamaChatModel() {
        return   OllamaChatModel.builder()
                .baseUrl("http://localhost:11434").modelName("deepseek-r1:7b")
                .build();
    }
    @Bean
    public OllamaStreamingChatModel getOllamaStreamingChatModel() {
        return  OllamaStreamingChatModel.builder()
                .baseUrl("http://localhost:11434").modelName("deepseek-r1:7b")
                .build();
    }
    @Bean
    public Assistant assistant(OllamaStreamingChatModel ollamaStreamingChatModel) {
        return AiServices.builder(Assistant.class)
                .streamingChatModel(ollamaStreamingChatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }

}

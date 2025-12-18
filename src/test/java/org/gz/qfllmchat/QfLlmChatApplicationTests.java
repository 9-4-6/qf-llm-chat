package org.gz.qfllmchat;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.gz.qfllmchat.service.Assistant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootTest
class QfLlmChatApplicationTests {

    @Test
    void contextLoads() throws URISyntaxException {



        OllamaChatModel ollamaChatModel = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434").modelName("deepseek-r1:7b")
                .build();
       /* SystemMessage systemMessage = SystemMessage.from("你好");
        Response<AiMessage> generate = ollamaChatModel.generate(systemMessage);
        System.out.println(generate.content());*/


       /* ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(ollamaChatModel)
                .chatMemory(chatMemory)
                .build();
        String answer = assistant.chat("Hello! My name is Klaus.");
        System.out.println(answer);
        String answerWithName = assistant.chat("What is my name?");
        System.out.println(answerWithName);*/

//        MathGenius mathGenius = AiServices.builder(MathGenius.class)
//                .chatModel(ollamaChatModel)
//                .tools(new Calculator())
//                .build();
//
//        String answer = mathGenius.ask("What is the square root of 475695037565?");
//
//        System.out.println(answer);

        URL resourceUrl = getClass().getClassLoader().getResource("documentation");
        if (resourceUrl != null) {
            Path documentsPath = Paths.get(resourceUrl.toURI());
            List<Document> documents = FileSystemDocumentLoader.loadDocuments(documentsPath.toString());
            InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
            EmbeddingStoreIngestor.ingest(documents, embeddingStore);

            Assistant assistant = AiServices.builder(Assistant.class)
                    .chatModel(ollamaChatModel)
                    .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                    .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore))
                    .build();

            String answer = assistant.chat("你叫什么");
            System.out.println(answer);
        } else {
            System.out.println("未找到 'documentation' 资源目录！");
        }



    }

}

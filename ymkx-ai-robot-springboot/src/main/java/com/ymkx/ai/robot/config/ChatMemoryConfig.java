package com.ymkx.ai.robot.config;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 聊天记忆配置
 * @author ymkx
 */
@Configuration
public class ChatMemoryConfig {

    /**
     * 记忆存储
     */
    @Resource
    private ChatMemoryRepository chatMemoryRepository;

    /**
     * 初始化一个 ChatMemory 实例，并注入到 Spring 容器中
     */
    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder()
                // 最大消息窗口为 50，默认值为 20
                .maxMessages(50)
                // 记忆存储
                .chatMemoryRepository(chatMemoryRepository)
                .build();
    }
}
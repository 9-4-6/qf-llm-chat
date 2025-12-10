# QF LLM Chat - 智能对话系统

## 📖 项目简介

QF LLM Chat 是一个基于 LangChain4j 框架构建的智能对话系统，集成了大语言模型、RAG（检索增强生成）技术和向量数据库，提供高效、准确的智能问答服务。

## 🏗️ 系统架构

| 层级 | 组件 | 技术栈 |
|------|------|--------|
| **前端层** | Web/移动端界面 | Vue/React/小程序 |
| **API网关层** | REST API接口 | Spring Boot |
| **业务逻辑层** | AI处理引擎 | LangChain4j, RAG引擎 |
| **数据存储层** | 向量数据库 | ChromaDB |
| **数据存储层** | 关系数据库 | MySQL |

## 🛠️ 技术栈

### 后端框架
- **Java 17+** - 主要编程语言
- **Spring Boot 3.x** - 应用框架

### AI/ML 框架
- **LangChain4j 0.31+** - AI应用开发框架
  - `langchain4j` - 核心框架
  - `langchain4j-ollama` - Ollama 集成
  - `langchain4j-spring-boot-starter` - Spring Boot 集成
- **Ollama** - 本地大模型部署
  - DeepSeek R1:7b
  - Llama 3
  - Qwen 等

### RAG 技术栈
- **向量数据库**：
  - **ChromaDB** - 开源向量数据库（默认）

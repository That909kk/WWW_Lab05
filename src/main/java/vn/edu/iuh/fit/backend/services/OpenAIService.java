package vn.edu.iuh.fit.backend.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class OpenAIService {

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/completions";

    private final WebClient webClient;

    // Khởi tạo WebClient
    public OpenAIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(OPENAI_API_URL).build();
    }

    public String getMatchScore(String candidateSkills, String jobDescription) throws Exception {
        String prompt = "Dựa trên kỹ năng của ứng viên \"" + candidateSkills + "\" và mô tả công việc \"" + jobDescription + "\", hãy cho biết độ phù hợp của ứng viên này với công việc. Trả lời dưới dạng một số điểm từ 0 đến 100.";

        // Tạo đối tượng request body dùng ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode requestBodyNode = objectMapper.createObjectNode();

        // Cấu hình các trường trong JSON
        requestBodyNode.put("model", "text-davinci-003");  // Hoặc "gpt-3.5-turbo" nếu bạn sử dụng GPT-3
        requestBodyNode.put("prompt", prompt);
        requestBodyNode.put("max_tokens", 50);

        // Chuyển đổi đối tượng JSON sang chuỗi JSON
        String requestBody = objectMapper.writeValueAsString(requestBodyNode);

        // Cấu hình HTTP header với API key
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Gửi HTTP POST request đến OpenAI API
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // In ra chi tiết lỗi để tìm hiểu nguyên nhân
            System.out.println("Error: " + e.getResponseBodyAsString());
            throw new RuntimeException("API Request failed with status code: " + e.getStatusCode());
        }
    }
}
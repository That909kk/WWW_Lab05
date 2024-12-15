package vn.edu.iuh.fit.backend.services;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;  // Thư viện Jackson để xử lý JSON

@Service
public class MLService {

    public double getMatchScore(String candidateSkills, String jobDescription) {
        try {
            // Tạo một ProcessBuilder để chạy script Python
            ProcessBuilder processBuilder = new ProcessBuilder("python", "D:\\python\\AIService.py");

            // Cấu hình input và output streams cho ProcessBuilder
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Gửi dữ liệu (kỹ năng ứng viên và mô tả công việc) cho Python
            String inputData = String.format("{\"candidate_skills\": \"%s\", \"job_description\": \"%s\"}", candidateSkills, jobDescription);
            try (OutputStream os = process.getOutputStream()) {
                os.write(inputData.getBytes());
                os.flush();
            }

            // Đọc kết quả trả về từ Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            // Kiểm tra nếu kết quả trả về là một JSON hợp lệ
            String resultJson = result.toString();

            if (resultJson.contains("error")) {
                throw new RuntimeException("Error from Python script: " + resultJson);
            }

            // Giải mã kết quả JSON trả về từ Python
            Map<String, Object> resultMap = new ObjectMapper().readValue(resultJson, Map.class);
            String matchScoreStr = resultMap.get("match_score").toString();

            return Double.parseDouble(matchScoreStr);

        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
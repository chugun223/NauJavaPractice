import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Задание № 4. HTTP клиент и JSON.");
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/anything"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            JsonNode acceptNode = root.path("headers").path("Accept");
            if (acceptNode.isMissingNode() || acceptNode.isNull()) {
                System.out.println("поле Accept отсутствует");
            }
            else {
                String accept = acceptNode.asText();
                System.out.println(accept);
            }
        }
        System.out.println("Задание №4 завершено.");
    }
}

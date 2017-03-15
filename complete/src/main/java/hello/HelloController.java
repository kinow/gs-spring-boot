package hello;

import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.language.spi.v1.LanguageServiceClient;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        try {
            LanguageServiceClient client = LanguageServiceClient.create();
            Analyze app = new Analyze(client);
            Analyze.printEntities(System.out, app.analyzeEntitiesFile("Greetings from Spring Boot!"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Greetings from Spring Boot!";
    }
    
}

package hello;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.language.spi.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Token;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        try {
            LanguageServiceClient client = LanguageServiceClient.create();
            Analyze app = new Analyze(client);
            List<Token> tokens = app.analyzeSyntaxText("Greetings from Spring Boot!");
            System.out.println(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Greetings from Spring Boot!";
    }
    
}

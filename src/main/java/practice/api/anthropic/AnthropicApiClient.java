package practice.api.anthropic;

import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;

public class AnthropicApiClient {
    public static void main(String[] args) {
        String apiKey = System.getenv("ANTHROPIC_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("Environment variable 'ANTHROPIC_API_KEY' is required but not set.");
        }
        AnthropicClient client = AnthropicOkHttpClient.fromEnv();

        MessageCreateParams params = MessageCreateParams.builder()
                .model("claude-sonnet-4-20250514")
                .maxTokens(1000)
                .temperature(1.0)
                .system("You are a world famous spiritual guru. Respond only with short wisdom stories.")
                .addUserMessage("What can you tell us about sikh guru nanak dev ji?")
                .build();

        Message message = client.messages().create(params);
        System.out.println(""+message.content());
    }
}

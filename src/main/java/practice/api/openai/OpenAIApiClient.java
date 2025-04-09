package practice.api.openai;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatCompletion;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatModel;

public class OpenAIApiClient {
    public static void main(String[] args) {

        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("Environment variable 'OPENAI_API_KEY' is required but not set.");
        }

        // Optionally validate other environment variables if required
        String orgId = System.getenv("OPENAI_ORG_ID");
        if (orgId == null || orgId.isEmpty()) {
            System.out.println("Warning: Environment variable 'OPENAI_ORG_ID' is not set. Continuing without it...");
        }

        // Configures using the `OPENAI_API_KEY`, `OPENAI_ORG_ID` and `OPENAI_PROJECT_ID`
        // environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage("Say this is a test")
                .model(ChatModel.GPT_4O_MINI)
                .build();
        ChatCompletion chatCompletion = client.chat().completions().create(params);
        
    }
}

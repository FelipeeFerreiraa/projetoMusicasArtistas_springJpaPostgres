package br.com.domFelipe.screenMusicProject.services;

import java.util.Optional;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class ConsultaChatGPT2 {

	// Carrega OPENAI_API_KEY do ambiente
	private static final OpenAIClient client = OpenAIOkHttpClient.builder().fromEnv()
			.apiKey(System.getenv("OPENAI_APIKEY")).build();

	private ConsultaChatGPT2() {
	}

	public static Optional<String> realizarPesquisa(String texto) {

		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder().model(ChatModel.GPT_3_5_TURBO) // ou
																												// ChatModel.GPT_4_1
				.addUserMessage("Quem é este artista/banda? '" + texto +"'")
				// .maxTokens(1000)
				.temperature(0.7).build();

		// Executa a chamada
		ChatCompletion chatCompletion = client.chat().completions().create(params);

		return chatCompletion.choices() // em vez de getChoices()
				.get(0).message() // em vez de getMessage()
				.content(); // em vez de getContent()
	}
}

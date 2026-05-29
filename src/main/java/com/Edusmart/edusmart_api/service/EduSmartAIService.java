package com.Edusmart.edusmart_api.service;

import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class EduSmartAIService {

    private final AdvertisingAI advertisingAI;

    public EduSmartAIService() {
        // Usar clave API por defecto o desde variables de entorno
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            apiKey = "sk-demo"; // Clave demo para desarrollo
        }
        this.advertisingAI = AiServices.builder(AdvertisingAI.class)
                .chatLanguageModel(OpenAiChatModel.withApiKey(apiKey))
                .build();
    }

    public String generarPublicidad(String tema, String audiencia) {
        return advertisingAI.generarPublicidad(tema, audiencia);
    }

    public interface AdvertisingAI {
        @UserMessage("Redacta una frase publicitaria de máximo 100 caracteres para vender un curso de {{tema}} dirigido a {{audiencia}}.")
        String generarPublicidad(String tema, String audiencia);
    }
}

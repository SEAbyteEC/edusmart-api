package com.Edusmart.edusmart_api.service;

import io.github.langchain4j.spring.annotation.AiService;
import io.github.langchain4j.spring.annotation.UserMessage;
import io.github.langchain4j.spring.annotation.V;

@AiService
public interface EduSmartAIService {

    @UserMessage("Redacta una frase publicitaria de máximo 100 caracteres para vender un curso de {{tema}} dirigido a {{audiencia}}.")
    String generarPublicidad(@V("tema") String tema, @V("audiencia") String audiencia);
}

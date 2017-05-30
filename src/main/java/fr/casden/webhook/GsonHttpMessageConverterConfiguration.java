package fr.casden.webhook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.google.gson.Gson;

import ai.api.GsonFactory;

@Configuration
public class GsonHttpMessageConverterConfiguration {

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson) {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(GsonFactory.getDefaultFactory().getGson());
        return converter;
    }
}
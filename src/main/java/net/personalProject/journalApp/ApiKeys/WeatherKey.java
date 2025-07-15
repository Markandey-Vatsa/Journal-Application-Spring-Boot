package net.personalProject.journalApp.ApiKeys;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class WeatherKey {
    private final String api_key = "dd7a62181fa754b5a677df46091d5ff7";
}


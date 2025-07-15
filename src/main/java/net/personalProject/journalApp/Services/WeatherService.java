package net.personalProject.journalApp.Services;


import net.personalProject.journalApp.ApiKeys.QuoteApiKey;
import net.personalProject.journalApp.ApiKeys.WeatherKey;
import net.personalProject.journalApp.apiResponse.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class WeatherService {

    @Autowired
    WeatherKey weatherKey;



    private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";


    @Autowired
    RestTemplate restTemplate;
//    https://api.weatherstack.com/current?access_key=dd7a62181fa754b5a677df46091d5ff7&query=New Delhi

    public WeatherResponse getWeather(String city){
       String url = API.replace("CITY",city).replace("API_KEY",weatherKey.getApi_key());
       ResponseEntity<WeatherResponse> response = restTemplate.exchange(url, HttpMethod.GET, null, WeatherResponse.class);
       WeatherResponse body = response.getBody();
       return body;
    }


}

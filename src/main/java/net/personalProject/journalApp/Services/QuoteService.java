package net.personalProject.journalApp.Services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    @Value("${quote.api.key}")
    private String api_key;
}

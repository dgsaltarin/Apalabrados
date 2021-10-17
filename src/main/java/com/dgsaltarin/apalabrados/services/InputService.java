package com.dgsaltarin.apalabrados.services;

import com.dgsaltarin.apalabrados.models.Text;
import com.dgsaltarin.apalabrados.repository.TextRepository;
import org.springframework.stereotype.Service;

@Service
public class InputService {

    private TextRepository textRepository;

    public InputService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public Text storeInput(String input) {
        Text testText = new Text(input, input.charAt(0), input.charAt(0));
        return this.textRepository.save(testText);
    }
}

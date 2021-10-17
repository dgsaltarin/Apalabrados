package com.dgsaltarin.apalabrados.services;

import com.dgsaltarin.apalabrados.models.Character;
import com.dgsaltarin.apalabrados.models.Number;
import com.dgsaltarin.apalabrados.models.Text;
import com.dgsaltarin.apalabrados.repository.CharacterRepository;
import com.dgsaltarin.apalabrados.repository.NumberRepository;
import com.dgsaltarin.apalabrados.repository.TextRepository;
import org.springframework.stereotype.Service;

@Service
public class InputService {

    private TextRepository textRepository;
    private NumberRepository numberRepository;
    private CharacterRepository characterRepository;

    public InputService(TextRepository textRepository, NumberRepository numberRepository,
                        CharacterRepository characterRepository) {
        this.textRepository = textRepository;
        this.characterRepository = characterRepository;
        this.numberRepository = numberRepository;
    }

    public String evaluateInput(String input) {
        String message = "";
        if (input.matches("^[0-9]+$") && input.length() >= 1) {
            Number number = new Number(Long.valueOf(input), Long.valueOf(input));
            Number higherAccumulated = this.numberRepository.findAllByAccumulatedOrderByAccumulatedAsc().get(0);
            System.out.println(higherAccumulated);
            this.storeNumber(number);
            message = "input saved in number";
        }
        if (input.matches("^[a-zA-Z]+$") && input.length() >= 1) {
            Text testText = new Text(input, input.charAt(0), input.charAt(input.length()));
            this.storeText(testText);
            message = "input saved in text";
        }
        if (!input.matches("^[a-zA-Z0-9]+$") && input.length() >= 1) {
            Character character = new Character(input.charAt(0));
            this.storeCharacter(character);
            message = "input saved in character";
        }
        return message;
    }

    private void storeText(Text input) {
        this.textRepository.save(input);
    }

    private void storeNumber(Number input) {
        this.numberRepository.save(input);
    }

    private void storeCharacter(Character input) {
        this.characterRepository.save(input);
    }
}

package com.dgsaltarin.apalabrados.services;

import com.dgsaltarin.apalabrados.models.Character;
import com.dgsaltarin.apalabrados.models.Number;
import com.dgsaltarin.apalabrados.models.Text;
import com.dgsaltarin.apalabrados.repository.CharacterRepository;
import com.dgsaltarin.apalabrados.repository.NumberRepository;
import com.dgsaltarin.apalabrados.repository.TextRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InputService {

    private final TextRepository textRepository;
    private final NumberRepository numberRepository;
    private final CharacterRepository characterRepository;

    public InputService(TextRepository textRepository, NumberRepository numberRepository,
                        CharacterRepository characterRepository) {
        this.textRepository = textRepository;
        this.characterRepository = characterRepository;
        this.numberRepository = numberRepository;
    }

    public String evaluateInput(String input) {
        String message = "";
        if (input.matches("^[0-9]+$") && input.length() >= 1) {
            long value = Long.parseLong(input);
            Number number = new Number(value, value);
            long higherAccumulated;
            try {
                higherAccumulated = this.numberRepository.findAll(Sort.by(Sort.Direction.DESC, "accumulated")).get(0).getAccumulated();
            } catch (IndexOutOfBoundsException e) {
                higherAccumulated = 0L;
            }
            number.setAccumulated(number.getAccumulated() + higherAccumulated);
            this.storeNumber(number);
            message = "input saved in number";
        }
        if (input.matches("^[a-zA-Z]+$") && input.length() >= 1) {
            Text testText = new Text(input, input.charAt(0), input.charAt(input.length()-1));
            this.storeText(testText);
            message = "input saved in text";
        }
        if (!input.matches("^[a-zA-Z0-9]+$") && input.length() >= 1) {
            String specialCharacters = input.replaceAll("[\\d\\w]", "");
            Character character = new Character(specialCharacters);
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

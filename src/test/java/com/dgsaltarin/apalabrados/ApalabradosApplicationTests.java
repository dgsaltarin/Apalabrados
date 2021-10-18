package com.dgsaltarin.apalabrados;

import com.dgsaltarin.apalabrados.controllers.ApalabradosController;
import com.dgsaltarin.apalabrados.models.Character;
import com.dgsaltarin.apalabrados.models.Number;
import com.dgsaltarin.apalabrados.models.Text;
import com.dgsaltarin.apalabrados.repository.CharacterRepository;
import com.dgsaltarin.apalabrados.repository.NumberRepository;
import com.dgsaltarin.apalabrados.repository.TextRepository;
import com.dgsaltarin.apalabrados.services.InputService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApalabradosApplicationTests {

    @Mock
    private CharacterRepository characterRepository;
    @Mock
    private TextRepository textRepository;
    @Mock
    private NumberRepository numberRepository;
    @InjectMocks
    private InputService inputService;

    @Test
    public void shouldReturnSavedInCharacterWhenSpecialCharacterIsSend() {
        characterRepository = mock(CharacterRepository.class);
        inputService = new InputService(textRepository, numberRepository, characterRepository);
        String input = ",hello";
        Character character = new Character(input);
        when(characterRepository.save(character)).thenReturn(any());
        assertEquals(inputService.evaluateInput(input), "input saved in character");
    }

    @Test
    public void shouldReturnSavedInTextWhenTextIsSend() {
        textRepository = mock(TextRepository.class);
        inputService = new InputService(textRepository, numberRepository, characterRepository);
        String input = "hello";
        Text text = new Text(input, 'h', 'o');
        when(textRepository.save(text)).thenReturn(any());
        assertEquals(inputService.evaluateInput(input), "input saved in text");
    }

    @Test
    public void ShouldReturnSavedInNumberWhenOnlyNumbersAreSend() {
        numberRepository = mock(NumberRepository.class);
        inputService = new InputService(textRepository, numberRepository, characterRepository);
        String input = "1234";
        Number number = new Number(123, 123);
        when(numberRepository.save(number)).thenReturn(any());
        assertEquals(inputService.evaluateInput(input), "input saved in number");
    }
}

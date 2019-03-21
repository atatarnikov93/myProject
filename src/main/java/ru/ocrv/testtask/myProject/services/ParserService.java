package ru.ocrv.testtask.myProject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ocrv.testtask.myProject.domain.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParserService {
    private static final ObjectMapper mapper = new ObjectMapper();
    ArrayList<Parser> output = new ArrayList<>(100000);

    // Парсинг JSON при помощи Jackson
    public void parseJson(String inputJson){
            try {
                output.add(mapper.readValue(inputJson, Parser.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    // Возвращаем id тех объектов, которые расположены в Екатеринбурге
    public List<String> responseAllObjects(){
        // использую StreamApi для удобства написания кода, сокращения кол-ва кода и параллельных вычислений
        List<String> result = output.parallelStream().filter(parser -> parser.getId_location().equals("Екатеринбург"))
                .map(parser -> parser.getId_sample())
                .collect(Collectors.toList());
        return result;
    }

    // второй вариант кода. Если в локации указаны координаты, то меняем их на название города
//    public List<String> responseAllObjects(){
//        // использую StreamApi для удобства написания кода, сокращения кол-ва кода и параллельных вычислений
//        output.parallelStream().forEach(parser -> {
//            if(parser.getId_location().equals("2525.5555")) {
//                parser.setId_location("Москва");
//            }
//        });
//        return output.stream().map(Parser::toString).collect(Collectors.toList());
//}
}

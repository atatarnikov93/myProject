package ru.ocrv.testtask.myProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ocrv.testtask.myProject.services.ParserService;

import java.util.List;

@RestController
@RequestMapping("rest/parser")
@RequiredArgsConstructor
public class ParserController {

    private final ParserService parserService;


    @GetMapping("list")
    public List<String> getListOfData() {
        return parserService.responseAllObjects();
    }

    @PostMapping
    public @ResponseBody
    void addData(@RequestBody String data) throws InterruptedException {
                parserService.parseJson(data);
    }

}

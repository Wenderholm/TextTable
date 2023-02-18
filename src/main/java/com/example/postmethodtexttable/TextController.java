package com.example.postmethodtexttable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TextController {

    @PostMapping("/generate")
    @ResponseBody
    String generateTable(@RequestParam String headers, @RequestParam String data){
        String[] headersArray = headers.split(TableGeneratorService.DATA_SEPARATOR);
        String[] dataRows = data.split("\n");
        String[][] dataArrays = new String[dataRows.length][];
        for (int i = 0; i < dataRows.length; i++) {
            dataArrays[i] = dataRows[i].split(TableGeneratorService.DATA_SEPARATOR);
        }
        return "<pre>" + TableGeneratorService.getTextTable(headersArray,dataArrays) + "</pre>";
    }
}

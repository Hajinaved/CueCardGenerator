package com.ccg.cuecardgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ccg")
@CrossOrigin(origins ="*")
public class ccgController {

    @Autowired
    private ccgService ccgService;

    @GetMapping("/getCard")
    public ResponseEntity<String> getCard() {
        String card = ccgService.getCard();
        return ResponseEntity.ok(card);
    }
}
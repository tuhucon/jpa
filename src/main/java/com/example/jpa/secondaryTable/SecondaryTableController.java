package com.example.jpa.secondaryTable;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("second")
@RequiredArgsConstructor
public class SecondaryTableController {
    private final OneRepository oneRepository;

    @PostMapping("one")
    public String insertNewOne() {
        One one = new One();
        one.setName("tu hu con");
        one.setAddress("ha noi");
        oneRepository.save(one);
        return "OK";
    }

    @GetMapping("one")
    public One getOne() {
        return oneRepository.findById(1).orElse(null);
    }
}

package com.djb.calculate.controller;

import com.djb.calculate.dto.MathResponse;
import com.djb.calculate.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.List;


@RestController
@RequestMapping("math")
public class MathControleur {

    @Autowired
    private MathService mathService;

    @GetMapping("square/{input}")
    public Mono<MathResponse> findSquare(@PathVariable int input){
        return this.mathService.findSquare(input);
    }

    @GetMapping("carre/{input}")
    public MathResponse findSquare2(@PathVariable int input){
        return this.mathService.findSquare2(input);
    }


    @GetMapping("table/{input}")
    public List<MathResponse> multiplicationTable(@PathVariable int input){
        return this.mathService.multiplicationTab2(input);
    }


}

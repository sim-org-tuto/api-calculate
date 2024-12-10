package com.djb.calculate.service;


import com.djb.calculate.dto.MathResponse;
import com.djb.calculate.util.SleepUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {


    public Mono<MathResponse> findSquare(int input){
        return Mono.fromSupplier(()-> input*input)
                .map(MathResponse::new);
    }


    public Flux<MathResponse> multiplicationTab(int input){
        return Flux.range(1, 10)
                .doOnNext(i -> SleepUtil.sleepSeconds(1))
                .doOnNext(i ->SleepUtil.sleepSeconds(1))
                .map(i -> new MathResponse(i* input));
    }

    public List<MathResponse> multiplicationTab2(int input){
        return IntStream.rangeClosed(1,10)
                .peek(i -> SleepUtil.sleepSeconds(1))
                .peek(i -> System.out.println("Math service processinh:" + i))
                .mapToObj(i ->  new MathResponse(i * input) )
                .collect(Collectors.toList());
    }

   public MathResponse findSquare2(int input){
        return new MathResponse(input * input);
    }


}

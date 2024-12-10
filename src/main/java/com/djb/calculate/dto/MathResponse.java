package com.djb.calculate.dto;

import lombok.*;

import java.util.Date;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MathResponse {

    private Date date = new Date();
    private int output;
    private int id;

    public MathResponse(int output){
        this.output = output;
    }
}

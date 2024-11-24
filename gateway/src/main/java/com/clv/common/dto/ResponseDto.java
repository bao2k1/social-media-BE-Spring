package com.clv.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Object content;
    private boolean hasErrors;
    private List<String> errors;
    private String timeStamp;
    private int statusCode;
}

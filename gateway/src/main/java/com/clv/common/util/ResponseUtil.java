package com.clv.common.util;

import com.clv.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<ResponseDto> get(Object dto, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDto
                        .builder()
                        .content(dto)
                        .hasErrors(false)
                        .errors(null)
                        .timeStamp(DateTimeUtil.now())
                        .statusCode(status.value())
                        .build(),
                status
        );
    }
}

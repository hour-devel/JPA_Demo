package com.example.jpa_demo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ApiResponse<T> {
    private String massag;
    private int code;
    private HttpStatus httpStatus;
    private T payload;
}

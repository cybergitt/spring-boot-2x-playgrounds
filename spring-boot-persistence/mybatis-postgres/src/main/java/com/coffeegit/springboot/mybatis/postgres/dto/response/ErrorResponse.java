package com.coffeegit.springboot.mybatis.postgres.dto.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErrorResponse {
    
    /**
     * error code
     */
    private String code;
    /**
     * short error message
     */
    private String message;

    /**
     * error cause timestamp
     */
    private Instant timestamp;
}

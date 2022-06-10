package com.facebook.facebook.modal;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer statusCode;
    private String message;
    private Object data;
}

package com.example.as4.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String status;
    private Object data;

    public Response(Object data) {
        this.data = data;
    }

    public Response(Object data, String status) {
        this.status = status;
        this.data = data;
    }

}

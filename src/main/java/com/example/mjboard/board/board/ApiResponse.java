package com.example.mjboard.board.board;

import lombok.Data;

@Data
public class ApiResponse {
    private Boolean succuss;
    private String msg;

    public ApiResponse(Boolean success,String msg){
        this.succuss = success;
        this.msg = msg;
    }
}

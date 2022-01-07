package com.comp5619.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseEntity implements Serializable {
    private static final long serialVersionUID = 3595741978061989861L;
    private Integer code;//code
    private String msg;//mssage
    private Object data;//response data

    public ResponseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
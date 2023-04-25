package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {
    private boolean success;
    private int code;
    private String message;
    private Object data;

    public static JsonResult success(Object data) {
        JsonResult jsonResult = new JsonResult();

        jsonResult.setSuccess(true);
        jsonResult.setData(data);

        return jsonResult;
    }
}

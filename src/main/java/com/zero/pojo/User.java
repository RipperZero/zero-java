package com.zero.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private String idcard;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Integer valid;

    private String createdUser;

    private String modifiedUser;

    private Date createdTime;

    private Date modifiedTime;
}

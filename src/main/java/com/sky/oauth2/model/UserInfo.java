package com.sky.oauth2.model;

import lombok.Data;

@Data
public class UserInfo {

    private String id;
    private String identifier;
    private String userName;
    private String password;
    private Long createTime;
    private Integer status;
    private String roleId;
    private String permissionId; //自定义的权限规则
    private Long lastLoginTime;

}

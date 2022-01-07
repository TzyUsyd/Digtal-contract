package com.comp5619.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@TableName("user")
public class User {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    private String userSeqId;
    private String userName;
    private int userGender;
    private String userEmail;
    private String userPassword;
    private int userVerification;
    private String userLicenceType;
    private String userLicenceId;
    private String userTel;
    private String userAddress;
    private String userSignature;
    private int userPremium;

}

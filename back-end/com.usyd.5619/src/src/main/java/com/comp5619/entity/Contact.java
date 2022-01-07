package com.comp5619.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@TableName("contact")
public class Contact {


    @TableId(value = "contact_id", type = IdType.AUTO)
    private Long userId;
    private String contactFirstName;
    private String contactLastName;
    private int contactGender;
    private String contactEmail;
    private int contactVerification;
    private String contactLicenceType;
    private String contactLicenceId;
    private String contactTel;
    private String contactAddress;
}

package com.comp5619.entity;


import java.sql.Time;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("contract")
public class Contract {

	@TableId(value = "contract_id", type = IdType.AUTO)
    private Long contractId;
    private Long userId;
    private String partybFirstName;
    private String partybLastName;
    private String partybEmail;
    private String partybLicenceType;
    private String partybLicenceId;
    private String partybTel;
    private String partybAddress;
    private Time period;
    private String contractContents;
    private String comments;
    private Byte[] attachment;
    private Byte[] form;

}

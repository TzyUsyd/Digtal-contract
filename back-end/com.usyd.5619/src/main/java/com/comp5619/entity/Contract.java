package com.comp5619.entity;


import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

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
    private String userId;
    private String partyaName;
    private String partyaEmail;
    private String partybName;
    private String partybEmail;
    private BigDecimal budget;
    private String partybLicenceType;
    private String partybLicenceId;
    private String partybTel;
    private String partybAddress;
    private String beginDate;
    private String endDate;
    private String contractContents;
    private String comments;
    private Byte[] attachment;
    private Byte[] form;
    

}

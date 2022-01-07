package com.comp5619.entity;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("receipt")
public class Receipt {

    @TableId(value = "own_id", type = IdType.AUTO)
    private Long ownId;
    private String userId;
    private String payerName;
    private int payerGender;
    private String payerEmail;
    private String payerLicenceType;
    private String payerLicenceId;
    private String payerTel;
    private String payerAddress;
    private BigDecimal amount;
    private String reason;
    private String date;
    private String paymentMethod;
    private String comments;
    private String attachment;
    private Byte[] form;
}

package com.comp5619.entity;

import java.math.BigDecimal;
import java.sql.Time;

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
    private Long userId;
    private String payerFirstName;
    private String payerLastName;
    private int payerGender;
    private String payerEmail;
    private String payerLicenceType;
    private String payerLicenceId;
    private String payerTel;
    private String payerAddress;
    private BigDecimal amount;
    private String reason;
    private Time period;
    private String paymentMethod;
    private String comments;
    private Byte[] attachment;
    private Byte[] form;
}

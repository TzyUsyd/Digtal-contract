package com.comp5619.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("iou")
public class Iou {

	@TableId(value = "iou_id", type = IdType.AUTO)
    private Long iouId;
    private String userId;
    private String payerName;
    private BigDecimal amount;
    private String reason;
    private String date;
    private String payerEmail;
//    private int payerGender;
//    private String payerAddress;
//    private String payerLicenceType;
//    private String payerLicenceId;
//    private String payerTel;
    
//    private BigDecimal interestRate;
//    private String paymentMethod;
//    private String comments;
//    private Byte[] attachment;
//    private Byte[] form;
}

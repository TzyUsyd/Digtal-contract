package com.comp5619.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.comp5619.entity.Contact;
import com.comp5619.entity.Contract;
import com.comp5619.entity.Iou;
import com.comp5619.entity.Receipt;
import com.comp5619.service.ContactService;
import com.comp5619.service.ContractService;
import com.comp5619.service.IouService;
import com.comp5619.service.ReceiptService;
import com.comp5619.service.UserService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;




@SpringBootTest
@Transactional
public class AllTest {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
    ReceiptService receiptService;
    
    @Autowired
    ContactService contactService;
    
    @Autowired
    ContractService contractService;
    
    @Autowired
    IouService iouService;
    
    @Autowired
    UserService userService;


    @Test
    public void addReceipttest() throws Exception {
    	Receipt re = new Receipt();
    	re.setUserId("asdas");
    	re.setPayerName("asda");
    	re.setPayerEmail("asdasd");
    	int i = 10;
    	BigDecimal b = new BigDecimal(i);
    	re.setAmount(b);
    	re.setReason("sadasd");
    	
    	Date date = new Date();
    	String datefor = sdf.format(date);
    	re.setDate(datefor);
    	String res = receiptService.addReceipt(re);
    	assert res.equals("The receipt has been added successfully");
        System.out.println(res);
    }
    
    @Test
    public void addIoutest() throws Exception {
    	Iou iou = new Iou();
    	iou.setUserId("asdas");
    	iou.setPayerName("asda");
    	iou.setPayerEmail("asdasd");
    	int i = 10;
    	BigDecimal b = new BigDecimal(i);
    	iou.setAmount(b);
    	iou.setReason("sadasd");
    	
    	Date date = new Date();
    	String datefor = sdf.format(date);
    	iou.setDate(datefor);
    	String res = iouService.addIou(iou);
    	assert res.equals("The IOU has been added successfully");
        System.out.println(res);
    }
    
    @Test
    public void addContracttest() throws Exception {
    	Contract con = new Contract();
    	con.setUserId("asdas");
    	con.setPartyaName("asda");
    	con.setPartyaEmail("asdasd");
    	con.setPartybName("asda");
    	con.setPartybEmail("asdasd");
    	int i = 10;
    	BigDecimal b = new BigDecimal(i);
    	con.setBudget(b);
    	con.setContractContents("sadasd");
    	
    	Date date = new Date();
    	String datefor = sdf.format(date);
    	con.setBeginDate(datefor);
    	con.setEndDate(datefor);
    	String res = contractService.addContract(con);
    	assert res.equals("The contract has been added successfully");
        System.out.println(res);
    }
    
    @Test
    public void addContacttest() throws Exception {
    	Contract con = new Contract();
    	con.setUserId("asdas");
    	con.setPartyaName("asda");
    	con.setPartyaEmail("asdasd");
    	con.setPartybName("asda");
    	con.setPartybEmail("asdasd");
    	int i = 10;
    	BigDecimal b = new BigDecimal(i);
    	con.setBudget(b);
    	con.setContractContents("sadasd");
    	
    	Date date = new Date();
    	String datefor = sdf.format(date);
    	con.setBeginDate(datefor);
    	con.setEndDate(datefor);
    	contactService.addContrContact(con);
    	
    }
    
    @Test
    public void bePremiumtest() throws Exception {
    	String id = "2";
    	String res=  userService.bePremium(id);
    	assert res.equals("Set user as premium user successfully!");
    	
    }




}

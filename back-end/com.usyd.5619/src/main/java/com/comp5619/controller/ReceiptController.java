package com.comp5619.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder.BinaryStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.comp5619.entity.Contact;
import com.comp5619.entity.Receipt;
import com.comp5619.entity.User;
import com.comp5619.mapper.ReceiptMapper;
import com.comp5619.service.ContactService;
import com.comp5619.service.ReceiptService;
import com.comp5619.vo.ResponseEntity;



@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@Controller
public class ReceiptController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ReceiptService receiptService;
    
    @Autowired
    ContactService contactService;
    
    @Autowired
    ReceiptMapper receiptMapper;
    

    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @PostMapping("/receipt/add")
    @ResponseBody
    public ResponseEntity addReceipt(@RequestBody Receipt receipt) throws Exception {
    	ResponseEntity responseEntity = new ResponseEntity();
    	String dateStr = receipt.getDate().split("T")[0];
    	receipt.setDate(dateStr);
        String i = receiptService.addReceipt(receipt);
        String str200="The receipt has been added successfully";
        if(i.equals(str200)) {
        	 contactService.addReContact(receipt);
        	 responseEntity.setMsg(i);
             responseEntity.setCode(200);
             return responseEntity;
        }
        
        responseEntity.setMsg(i);
        responseEntity.setCode(400);
        return responseEntity;

    }
  
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/receipt/{id}")
    @ResponseBody
    public List<Receipt> getReceipts(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Receipt> queryWrapper = new QueryWrapper<Receipt>();
   	    queryWrapper.eq("user_id", id).orderByDesc("own_id");
        return this.receiptMapper.selectList(queryWrapper);

    }
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/receipt/suc/{id}")
    @ResponseBody
    public Receipt getReceipt(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Receipt> queryWrapper = new QueryWrapper<Receipt>();
   	    queryWrapper.eq("user_id", id).orderByDesc("own_id");
        List<Receipt> receiptList= this.receiptMapper.selectList(queryWrapper);
        return receiptList.get(0);
    }
    
    @GetMapping("/receipt/delete/{id}")
    @ResponseBody
    public void deleteReceipt(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Receipt> queryWrapper = new QueryWrapper<Receipt>();
   	    queryWrapper.eq("own_Id", id);
        this.receiptMapper.delete(queryWrapper);
    }

   
   

}

package com.comp5619.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import com.comp5619.mapper.UserMapper;
import com.comp5619.service.ContactService;
import com.comp5619.service.ReceiptService;
import com.comp5619.service.UserService;
import com.comp5619.vo.ResponseEntity;



@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@Controller
public class UserController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ReceiptService receiptService;
    
    @Autowired
    ContactService contactService;
    
  
    
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    UserService userService;
    

    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @PostMapping("/user/signature/{id}")
    @ResponseBody
    public ResponseEntity uploadSignature(@PathVariable("id") String id,MultipartFile image) throws Exception {
    	ResponseEntity responseEntity = new ResponseEntity();
    	String path = userService.saveSigniture(image);
    	if(path.equals("Opps, some errors happend")) {
    		  responseEntity.setMsg(path);
    	      responseEntity.setCode(400);
    	      System.out.println(responseEntity.getCode()+": "+responseEntity.getMsg());
    	      return responseEntity;
    	}else {
	    	QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
	   	    queryWrapper.eq("user_seq_id", id);
	   	    int i = userMapper.selectCount(queryWrapper);
	   	    if(i>0) {
	   	    	User curUser = userMapper.selectOne(queryWrapper);
	   	    	curUser.setUserSignature(path);
	   	    	int m = userMapper.updateById(curUser);
	   	    	if(m==1) {
	   	    	  responseEntity.setMsg("Upload successfully!");
	    	      responseEntity.setCode(200);
	    	      System.out.println(responseEntity.getCode()+": "+responseEntity.getMsg());
	    	      return responseEntity;
	   	    	}else {
	   	    	  responseEntity.setMsg("Update database error!");
	      	      responseEntity.setCode(400);
	      	      System.out.println(responseEntity.getCode()+": "+responseEntity.getMsg());
	      	      return responseEntity;
	   	    	}
	   	    }else {
	   	    	User curUser = new User();
	   	    	curUser.setUserSeqId(id);
	   	    	curUser.setUserSignature(path);
	   	    	int m = userMapper.insert(curUser);
	   	    	if(m==1) {
	   	    	  responseEntity.setMsg("Upload successfully!");
	    	      responseEntity.setCode(200);
	    	      System.out.println(responseEntity.getCode()+": "+responseEntity.getMsg());
	    	      return responseEntity;
	   	    	}else {
	   	    	  responseEntity.setMsg("Update database error!");
	      	      responseEntity.setCode(400);
	      	      System.out.println(responseEntity.getCode()+": "+responseEntity.getMsg());
	      	      return responseEntity;
	   	    	}
	   	    }
    	}
    }

    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/user/get_signature/{id}")
    @ResponseBody
    public String getSignature(@PathVariable("id") String id) throws Exception {
    	System.out.println(id);
    	String path =null;
    	QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
   	    queryWrapper.eq("user_seq_id", id);
   	    int i = userMapper.selectCount(queryWrapper);
	   
	    if(i>0) {
	    	 User curUser = userMapper.selectOne(queryWrapper);
	    	 path = curUser.getUserSignature();
	    	 System.out.println(path);
	    	 return path;
	    }else {
	    	System.out.println(path);
	    	return path;
	    }
    }
    
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/user/premium/{id}")
    @ResponseBody
    public ResponseEntity setPremium(@PathVariable("id") String id) throws Exception {
    	ResponseEntity responseEntity = new ResponseEntity();
    	String res = userService.bePremium(id);
    	responseEntity.setMsg(res);
    	if(res.equals("Set user as premium user successfully!")) {
  	      responseEntity.setCode(200);
  	      return responseEntity;
    	}else {
    		responseEntity.setCode(400);
    		return responseEntity;
    	}
	    
    }
   
   

}

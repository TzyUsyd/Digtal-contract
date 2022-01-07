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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.comp5619.entity.Iou;
import com.comp5619.entity.Receipt;
import com.comp5619.entity.User;
import com.comp5619.mapper.IouMapper;
import com.comp5619.mapper.ReceiptMapper;
import com.comp5619.service.ContactService;
import com.comp5619.service.IouService;
import com.comp5619.service.ReceiptService;
import com.comp5619.vo.ResponseEntity;


@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@Controller
public class IouController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    IouService iouService;
    
    @Autowired
    IouMapper iouMapper;
    
    @Autowired
    ContactService contactService;


    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @PostMapping("/iou/add")
    @ResponseBody
    public ResponseEntity addIou(@RequestBody Iou iou) throws Exception {
    	ResponseEntity responseEntity = new ResponseEntity();
    	//Date date = sdf.parse(iou.getDate());
    	String dateStr = iou.getDate().split("T")[0];
    	iou.setDate(dateStr);
        String i = iouService.addIou(iou);
        String str200="The IOU has been added successfully";
        if(i.equals(str200)) {
        	 contactService.addIouContact(iou);
        	 responseEntity.setMsg(i);
             responseEntity.setCode(200);
             return responseEntity;
        }
        
        responseEntity.setMsg(i);
        responseEntity.setCode(400);
        return responseEntity;

    }
  
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/iou/{id}")
    @ResponseBody
    public List<Iou> getIous(@PathVariable("id") String id) throws Exception {
    	
    	QueryWrapper<Iou> queryWrapper = new QueryWrapper<Iou>();
   	    queryWrapper.eq("user_id", id).orderByDesc("iou_id");
        return this.iouMapper.selectList(queryWrapper);

    }
    
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/iou/suc/{id}")
    @ResponseBody
    public Iou getIou(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Iou> queryWrapper = new QueryWrapper<Iou>();
   	    queryWrapper.eq("user_id", id).orderByDesc("iou_id");
        List<Iou> iouList= this.iouMapper.selectList(queryWrapper);
      
        return iouList.get(0);
     

    }
    
    @GetMapping("/iou/delete/{id}")
    @ResponseBody
    public void deleteIou(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Iou> queryWrapper = new QueryWrapper<Iou>();
   	    queryWrapper.eq("iou_Id", id);
        this.iouMapper.delete(queryWrapper);
    }

   
   

}

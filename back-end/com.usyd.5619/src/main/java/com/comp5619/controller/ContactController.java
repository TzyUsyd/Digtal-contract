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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.comp5619.entity.Contact;
import com.comp5619.entity.Iou;
import com.comp5619.entity.Receipt;
import com.comp5619.entity.User;
import com.comp5619.mapper.ContactMapper;
import com.comp5619.mapper.IouMapper;
import com.comp5619.mapper.ReceiptMapper;
import com.comp5619.service.ContactService;
import com.comp5619.service.IouService;
import com.comp5619.service.ReceiptService;
import com.comp5619.vo.ResponseEntity;



@Controller
public class ContactController {
	

    @Autowired
    ContactService contactService;
    
    @Autowired
    ContactMapper contactMapper;
    
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/contacts/{id}")
    @ResponseBody
    public List<Contact> getContacts(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Contact> queryWrapper = new QueryWrapper<Contact>();
   	    queryWrapper.eq("user_id", id).orderByDesc("contact_id");
        return this.contactMapper.selectList(queryWrapper);
    

    }
}

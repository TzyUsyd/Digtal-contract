package com.comp5619.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5619.entity.Contact;
import com.comp5619.entity.Contract;
import com.comp5619.entity.Iou;
import com.comp5619.entity.Receipt;
import com.comp5619.mapper.ContactMapper;
import com.comp5619.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {


    @Autowired
    ContactMapper contactMapper;
    
    
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addReContact(Receipt receipt) {
      
    	QueryWrapper<Contact> queryWrapper =new QueryWrapper<Contact>();
        queryWrapper.eq("contact_email",receipt.getPayerEmail());
        if(contactMapper.selectCount(queryWrapper)==1) {}
        else {
        	Contact recContact = new Contact();
            recContact.setContactName(receipt.getPayerName());
            recContact.setUserId(receipt.getUserId());
            recContact.setContactEmail(receipt.getPayerEmail());
            
            contactMapper.insert(recContact);
        }
       
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addIouContact(Iou iou) {
      
    	QueryWrapper<Contact> queryWrapper =new QueryWrapper<Contact>();
        queryWrapper.eq("contact_email",iou.getPayerEmail());
        if(contactMapper.selectCount(queryWrapper)==1) {}
        else {
	    	Contact IouContact = new Contact();
	    	IouContact.setContactName(iou.getPayerName());
	    	IouContact.setUserId(iou.getUserId());
	    	IouContact.setContactEmail(iou.getPayerEmail());
	        contactMapper.insert(IouContact); 
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void addContrContact(Contract contract) {
      
    	QueryWrapper<Contact> queryWrapper =new QueryWrapper<Contact>();
        queryWrapper.eq("contact_email",contract.getPartybEmail());
        if(contactMapper.selectCount(queryWrapper)==1) {}
        else {
	    	Contact contrContact = new Contact();
	    	contrContact.setContactName(contract.getPartybName());
	    	contrContact.setUserId(contract.getUserId());
	    	contrContact.setContactEmail(contract.getPartybEmail());
	        contactMapper.insert(contrContact);
        }
    }



}

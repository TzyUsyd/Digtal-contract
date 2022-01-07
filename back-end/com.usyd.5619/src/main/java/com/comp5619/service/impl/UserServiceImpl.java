package com.comp5619.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5619.entity.User;
import com.comp5619.mapper.UserMapper;
import com.comp5619.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String saveSigniture(MultipartFile image) {
    	System.out.println(image.getName());
     	String oldName = image.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        String realPath = "G:\\2021s2\\5619\\Archive\\public\\images";
        File toFile = new File(realPath);
        if(!toFile.exists()) {
        	toFile.mkdirs();
        }
        try {
        	image.transferTo(new File(toFile,newName));
        	return newName;
        } catch (IOException e) {
        	e.printStackTrace();
        	return "Opps, some errors happend";
        }
    	
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String bePremium(String id) {
    	QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
   	    queryWrapper.eq("user_seq_id", id);
   	    int i = userMapper.selectCount(queryWrapper);
	   
	    if(i>0) {
	    	 User curUser = userMapper.selectOne(queryWrapper);
	    	 curUser.setUserPremium(1);
	    	 int y = userMapper.updateById(curUser);
	    	 return  y==1?"Set user as premium user successfully!":"Opps, some errors happend";
	    }else {
	    	User curUser = new User();
   	    	curUser.setUserSeqId(id);
   	    	curUser.setUserPremium(1);
   	    	int m = userMapper.insert(curUser);
   	    	return  m==1?"Set user as premium user successfully!":"Opps, some errors happend";
	    }   	
    }

}

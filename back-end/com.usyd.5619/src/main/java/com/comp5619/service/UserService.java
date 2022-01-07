package com.comp5619.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5619.entity.User;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface UserService extends IService<User> {
	
	String saveSigniture(MultipartFile image);
    String bePremium(String id);
 
}

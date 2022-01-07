package com.comp5619.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5619.entity.Iou;
import com.comp5619.entity.Receipt;


public interface IouService extends IService<Iou> {
	String addIou(Iou iou);

}

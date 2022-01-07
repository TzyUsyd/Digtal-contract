package com.comp5619.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5619.entity.Iou;
import com.comp5619.mapper.IouMapper;
import com.comp5619.service.IouService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IouServiceImpl extends ServiceImpl<IouMapper, Iou> implements IouService {

    @Autowired
    IouMapper iouMapper;

}   

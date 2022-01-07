package com.comp5619.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5619.entity.Receipt;
import com.comp5619.mapper.ReceiptMapper;
import com.comp5619.service.ReceiptService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptImpl extends ServiceImpl<ReceiptMapper, Receipt> implements ReceiptService {
    @Autowired
    ReceiptMapper receiptMapper;


}

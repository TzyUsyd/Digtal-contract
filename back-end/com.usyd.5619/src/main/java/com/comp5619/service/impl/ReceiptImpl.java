package com.comp5619.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5619.entity.Receipt;
import com.comp5619.mapper.ReceiptMapper;
import com.comp5619.service.ReceiptService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceiptImpl extends ServiceImpl<ReceiptMapper, Receipt> implements ReceiptService {
   
		@Autowired
	    ReceiptMapper receiptMapper;

	    @Override
	    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	    public String addReceipt(Receipt receipt) {
	        boolean saveStu=receiptMapper.insert(receipt)==1?true:false;
	        
	        String suc="The receipt has been added successfully" ;
	        String def="Opps, some errors happened" ;
	        
	        return saveStu? suc:def;	    
	    }
}

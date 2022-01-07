package com.comp5619.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5619.entity.Contract;
import com.comp5619.entity.Iou;
import com.comp5619.mapper.ContractMapper;
import com.comp5619.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements ContractService {

    @Autowired
    ContractMapper contractMapper;
    
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String addContract(Contract contract) {
    	
    

        boolean saveStu=contractMapper.insert(contract)==1?true:false;
        
        String suc="The contract has been added successfully" ;
        String def="Opps, some errors happened" ;
        
        return saveStu? suc:def;	    
    }

   
}

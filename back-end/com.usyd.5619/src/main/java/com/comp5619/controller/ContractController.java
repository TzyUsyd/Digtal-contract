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
import com.comp5619.entity.Contract;
import com.comp5619.entity.Iou;
import com.comp5619.entity.Receipt;
import com.comp5619.entity.User;
import com.comp5619.mapper.ContactMapper;
import com.comp5619.mapper.ContractMapper;
import com.comp5619.mapper.ReceiptMapper;
import com.comp5619.service.ContactService;
import com.comp5619.service.ContractService;
import com.comp5619.service.ReceiptService;
import com.comp5619.vo.ResponseEntity;


@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@Controller
public class ContractController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    ContractService contractService;
    
    @Autowired
    ContractMapper contractMapper;
    
    @Autowired
    ContactService contactService;
    
    
    @PostMapping("/contract/add")
    @ResponseBody
    public ResponseEntity addContract(@RequestBody Contract contract) throws Exception {
    	ResponseEntity responseEntity = new ResponseEntity();
    	
    	String dateBegin = contract.getBeginDate().split("T")[0];
    	contract.setBeginDate(dateBegin);
    	String dateEnd = contract.getEndDate().split("T")[0];
    	contract.setEndDate(dateEnd);
        String i = contractService.addContract(contract);
        String str200="The contract has been added successfully";
        if(i.equals(str200)) {
        	 contactService.addContrContact(contract);
        	 responseEntity.setMsg(i);
             responseEntity.setCode(200);
             return responseEntity;
        }
        
        responseEntity.setMsg(i);
        responseEntity.setCode(400);
        return responseEntity;

    }
  
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/contract/{id}")
    @ResponseBody
    public List<Contract> getContracts(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Contract> queryWrapper = new QueryWrapper<Contract>();
   	    queryWrapper.eq("user_id", id).orderByDesc("contract_id");
      
        return this.contractMapper.selectList(queryWrapper);

    }
    
    @CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
    @GetMapping("/contract/suc/{id}")
    @ResponseBody
    public Contract getIou(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Contract> queryWrapper = new QueryWrapper<Contract>();
   	    queryWrapper.eq("user_id", id).orderByDesc("contract_id");
        List<Contract> contractList= this.contractMapper.selectList(queryWrapper);
        return contractList.get(0);
     

    }
    
    
    @GetMapping("/contract/delete/{id}")
    @ResponseBody
    public void deleteContract(@PathVariable("id") String id) throws Exception {
    	QueryWrapper<Contract> queryWrapper = new QueryWrapper<Contract>();
   	    queryWrapper.eq("contract_Id", id);
        this.contractMapper.delete(queryWrapper);
    }



   
   

}

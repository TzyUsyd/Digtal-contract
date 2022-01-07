package com.comp5619.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5619.entity.Contract;
import com.comp5619.entity.Iou;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;



public interface ContractService extends IService<Contract> {
	String addContract(Contract contract);


}

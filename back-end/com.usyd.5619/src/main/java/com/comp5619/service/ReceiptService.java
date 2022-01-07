package com.comp5619.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5619.entity.Receipt;


import java.util.List;

public interface ReceiptService extends IService<Receipt> {
	
	
	String addReceipt(Receipt receipt);



}

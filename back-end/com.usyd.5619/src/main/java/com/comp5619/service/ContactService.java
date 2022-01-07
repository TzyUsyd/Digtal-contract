package com.comp5619.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5619.entity.Contact;
import com.comp5619.entity.Contract;
import com.comp5619.entity.Iou;
import com.comp5619.entity.Receipt;

import java.util.List;
import java.util.Map;

public interface ContactService extends IService<Contact> {

	void addReContact(Receipt receipt);
	void addIouContact(Iou iou);
	void addContrContact(Contract contract);

}

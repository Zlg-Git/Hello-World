package com.zlg.gmall.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import com.zlg.gmall.bean.UserAddress;
import com.zlg.gmall.service.OrderService;
import com.zlg.gmall.service.UserService;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

	//@Autowired
	@Reference //dubbo直连
	UserService userService;

	@Override
	public List<UserAddress> initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id：" + userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		return addressList;
	}
}

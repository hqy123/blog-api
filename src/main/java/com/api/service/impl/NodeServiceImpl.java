package com.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.NodeMapper;
import com.api.service.NodeService;
@Service
public class NodeServiceImpl implements NodeService{
	
	@Autowired
	NodeMapper nodeMapper;
	
	@Override
	public int addNode(String str) {
	
		return nodeMapper.addNode(str);
	}

}

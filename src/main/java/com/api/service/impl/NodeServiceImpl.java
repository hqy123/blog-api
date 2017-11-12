package com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.NodeMapper;
import com.api.pojo.Node;
import com.api.service.NodeService;
@Service
public class NodeServiceImpl implements NodeService{
	
	@Autowired
	NodeMapper nodeMapper;
	
	@Override
	public int addNode(String str) {
		return nodeMapper.addNode(str);
	}

	@Override
	public List<Node> getNodeList() {
		return nodeMapper.getNodeList();
	}

	@Override
	public int delNodeById(int id) {
		return nodeMapper.delNodeById(id);
	}

}

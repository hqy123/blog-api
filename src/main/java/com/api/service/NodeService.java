package com.api.service;

import java.util.List;

import com.api.pojo.Node;

public interface NodeService {
	
	public int addNode(String str);

	public List<Node> getNodeList();

	public int delNodeById(int id);
}

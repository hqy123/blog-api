package com.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.pojo.Node;

@Repository
public interface NodeMapper {
	public int addNode(String str);

	public List<Node> getNodeList();

	public int delNodeById(int id);
}

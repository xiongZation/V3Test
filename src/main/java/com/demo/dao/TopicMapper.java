package com.demo.dao;

import com.demo.pojo.Topic;
import net.sf.jsqlparser.statement.select.Top;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer topicid);

    int insert(Topic record);

    int insertSelective(Topic record);

    List<Topic> topicAll();

    Topic selectByPrimaryKey(Integer topicid);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);
}
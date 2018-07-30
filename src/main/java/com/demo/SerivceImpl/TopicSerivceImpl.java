package com.demo.SerivceImpl;

import com.demo.Serivce.TopicSerivce;
import com.demo.dao.TopicMapper;
import com.demo.pojo.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
@Controller
@Service
public class TopicSerivceImpl implements TopicSerivce {
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public List<Topic> topicAll() {
        return topicMapper.topicAll();
    }
}

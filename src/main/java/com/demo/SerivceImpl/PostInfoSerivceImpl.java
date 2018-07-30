package com.demo.SerivceImpl;

import com.demo.Serivce.PostInfoSerivce;
import com.demo.dao.PostInfoMapper;
import com.demo.pojo.PostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostInfoSerivceImpl implements PostInfoSerivce {
    @Autowired
    private PostInfoMapper postInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer topid) {
        return postInfoMapper.deleteByPrimaryKey(topid);
    }

    @Override
    public int insert(PostInfo record) {
        return postInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(PostInfo record) {
        return postInfoMapper.insertSelective(record);
    }

    @Override
    public PostInfo selectByPrimaryKey(Integer topid) {
        return postInfoMapper.selectByPrimaryKey(topid);
    }

    @Override
    public int updateNum( Integer topid) {
        return postInfoMapper.updateNum(topid);
    }

    @Override
    public List<PostInfo> selectAll(String postname, int posttypeid, int top, int bom) {
        return postInfoMapper.selectAll(postname,posttypeid,top,bom);
    }

    @Override
    public int updateByPrimaryKeySelective(PostInfo record) {
        return postInfoMapper.updateByPrimaryKeySelective(record) ;
    }

    @Override
    public int updateByPrimaryKey(PostInfo record) {
        return postInfoMapper.updateByPrimaryKey(record);
    }
}

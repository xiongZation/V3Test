package com.demo.Serivce;

import com.demo.pojo.PostInfo;

import java.util.List;

public interface PostInfoSerivce {
    int deleteByPrimaryKey(Integer topid);

    int insert(PostInfo record);

    int insertSelective(PostInfo record);

    PostInfo selectByPrimaryKey(Integer topid);

    int updateNum(Integer topid);

    List<PostInfo> selectAll(String postname, int posttypeid, int top, int bom);

    int updateByPrimaryKeySelective(PostInfo record);

    int updateByPrimaryKey(PostInfo record);
}

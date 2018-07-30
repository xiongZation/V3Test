package com.demo.dao;

import com.demo.pojo.PostInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostInfoMapper {
    int deleteByPrimaryKey(Integer topid);

    int insert(PostInfo record);

    int insertSelective(PostInfo record);

    PostInfo selectByPrimaryKey(Integer topid);

    int updateNum(Integer topid);

    List<PostInfo> selectAll(@Param("postname") String postname, @Param("posttypeid")int posttypeid, @Param("top")int top, @Param("bom")int bom);

    int updateByPrimaryKeySelective(PostInfo record);

    int updateByPrimaryKey(PostInfo record);
}
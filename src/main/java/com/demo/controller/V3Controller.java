package com.demo.controller;

import com.demo.Serivce.PostInfoSerivce;
import com.demo.Serivce.TopicSerivce;
import com.demo.pojo.PostInfo;
import com.demo.pojo.Topic;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@SessionAttributes({"PageInfo"})
public class V3Controller {
    @Autowired
    private PostInfoSerivce postInfoSerivce;
    @Autowired
    private TopicSerivce topicSerivce;

    @RequestMapping("/selectAll.do")
    public String selectIndex(@RequestParam(value = "posttypeid",required = false,defaultValue = "0")Integer posttypeid,
                              @RequestParam(value = "postname",required = false,defaultValue = "")String postname,
                              @RequestParam(value = "topnum",required = false,defaultValue = "0")Integer topnum,
                              @RequestParam(value = "bomnum",required = false,defaultValue = "0")Integer bomnum,
                              @RequestParam(value = "now",required = false,defaultValue = "1")Integer now, ModelMap map){
        PageHelper.startPage(now,3);
        List<PostInfo> postInfos = postInfoSerivce.selectAll(postname, posttypeid, topnum, bomnum);
        PageInfo<PostInfo> PageInfo = new PageInfo<>(postInfos);
        map.put("PageInfo",PageInfo);
        List<Topic> topics = topicSerivce.topicAll();
        map.put("Topic",topics);
        map.put("posttypeid",posttypeid);
        map.put("postname",postname);
        map.put("topnum",topnum);
        map.put("bomnum",bomnum);

        return "index";
    }

    @RequestMapping("insert.do")
    public String insertPost(ModelMap map){
        List<Topic> topics = topicSerivce.topicAll();
        map.put("topics",topics);
        return "add";
    }

    //新增
    @RequestMapping("add.do")
    public void AddPostInfo(PostInfo postInfo, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int i = postInfoSerivce.insert(postInfo);
        PrintWriter PWriter = response.getWriter();
        if(i>0){
            PWriter.write("<script type='text/javascript'>alert('新增成功');location.href='selectAll.do'</script>");
        }else {
            PWriter.write("<script type='text/javascript'>alert('新增失败');location.href='insert.do'</script>");
        }
    }

    //加载修改
    @RequestMapping("EditId.do")
    public String edit(Integer topid ,ModelMap map){
        PostInfo postInfo = postInfoSerivce.selectByPrimaryKey(topid);
        map.put("post",postInfo);
        List<Topic> topics = topicSerivce.topicAll();
        map.put("topics",topics);
        return "edit";
    }

    //修改
    @RequestMapping("UpdateEdit.do")
    public void UpdateEdit(PostInfo postInfo,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int i = postInfoSerivce.updateByPrimaryKeySelective(postInfo);
        PrintWriter PWriter = response.getWriter();
        if(i>0){
            PWriter.write("<script type='text/javascript'>alert('修改成功');location.href='selectAll.do'</script>");
        }else {
            PWriter.write("<script type='text/javascript'>alert('修改失败');location.href='EditId.do'</script>");
        }
    }

    //查看详情，并把点击数加1
    @RequestMapping("Details.do")
    public String Details(Integer topid,ModelMap map){
        int i = postInfoSerivce.updateNum(topid);
        System.out.println(i);
        PostInfo postInfo = postInfoSerivce.selectByPrimaryKey(topid);
        map.put("post",postInfo);
        System.out.println(postInfo);
        return "details";
    }

    //删除
    @RequestMapping("delete.do")
    public void deleteById(Integer topid,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int i = postInfoSerivce.deleteByPrimaryKey(topid);
        PrintWriter PWriter = response.getWriter();
        if(i>0){
            PWriter.write("<script type='text/javascript'>alert('删除成功');location.href='selectAll.do'</script>");
        }else {
            PWriter.write("<script type='text/javascript'>alert('删除失败');location.href='selectAll.do'</script>");
        }
    }
}

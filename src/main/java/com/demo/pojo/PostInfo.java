package com.demo.pojo;

import java.util.Date;

public class PostInfo {
    private Integer topid;

    private Date posttime;

    private Integer clicknum;

    private String content;

    private String postname;

    private Integer posttypeid;

    private String picpath;

    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Integer getTopid() {
        return topid;
    }

    public void setTopid(Integer topid) {
        this.topid = topid;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname == null ? null : postname.trim();
    }

    public Integer getPosttypeid() {
        return posttypeid;
    }

    public void setPosttypeid(Integer posttypeid) {
        this.posttypeid = posttypeid;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath == null ? null : picpath.trim();
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "topid=" + topid +
                ", posttime=" + posttime +
                ", clicknum=" + clicknum +
                ", content='" + content + '\'' +
                ", postname='" + postname + '\'' +
                ", posttypeid=" + posttypeid +
                ", picpath='" + picpath + '\'' +
                ", topic=" + topic +
                '}';
    }
}
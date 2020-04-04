package com.hitencent.samples.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ProjectsParent {
    @JSONField(ordinal = 0)
    private int id;
    @JSONField(ordinal = 1)
    private int project_id;
    @JSONField(ordinal = 2)
    private String project_name;
    @JSONField(ordinal = 3)
    private String feature_name;
    @JSONField(ordinal = 4)
    private String feature_name_en;
    @JSONField(ordinal = 5)
    private String url_tag;
    @JSONField(ordinal = 6)
    private List<Object> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String feature_name) {
        this.feature_name = feature_name;
    }

    public String getFeature_name_en() {
        return feature_name_en;
    }

    public void setFeature_name_en(String feature_name_en) {
        this.feature_name_en = feature_name_en;
    }

    public String getUrl_tag() {
        return url_tag;
    }

    public void setUrl_tag(String url_tag) {
        this.url_tag = url_tag;
    }

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ProjectsParent{" +
                "id=" + id +
                ", project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", feature_name='" + feature_name + '\'' +
                ", feature_name_en='" + feature_name_en + '\'' +
                ", url_tag='" + url_tag + '\'' +
                ", children=" + children +
                '}';
    }
}

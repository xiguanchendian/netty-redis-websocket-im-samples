package com.hitencent.samples.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ProjectFeatureParent {
    @JSONField(ordinal = 0)
    private int id;
    @JSONField(ordinal = 1)
    private int project_id;
    @JSONField(ordinal = 2)
    private String project_name;
    @JSONField(ordinal = 3)
    private int feature_id;
    @JSONField(ordinal = 4)
    private String feature_name;
    @JSONField(ordinal = 5)
    private String one_name;
    @JSONField(ordinal = 6)
    private String one_name_en;
    @JSONField(ordinal = 7)
    private String url_tag;
    @JSONField(ordinal = 8)
    private List<ProjectFeatureChildren> children;

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

    public int getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(int feature_id) {
        this.feature_id = feature_id;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String feature_name) {
        this.feature_name = feature_name;
    }

    public String getOne_name() {
        return one_name;
    }

    public void setOne_name(String one_name) {
        this.one_name = one_name;
    }

    public String getOne_name_en() {
        return one_name_en;
    }

    public void setOne_name_en(String one_name_en) {
        this.one_name_en = one_name_en;
    }

    public String getUrl_tag() {
        return url_tag;
    }

    public void setUrl_tag(String url_tag) {
        this.url_tag = url_tag;
    }

    public List<ProjectFeatureChildren> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectFeatureChildren> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ProjectFeatureParent{" +
                "id=" + id +
                ", project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", feature_id=" + feature_id +
                ", feature_name='" + feature_name + '\'' +
                ", one_name='" + one_name + '\'' +
                ", one_name_en='" + one_name_en + '\'' +
                ", url_tag='" + url_tag + '\'' +
                ", children=" + children +
                '}';
    }
}

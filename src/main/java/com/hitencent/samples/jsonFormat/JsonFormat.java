package com.hitencent.samples.jsonFormat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hitencent.samples.bean.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * json字符串格式转换类
 */
@Component
public class JsonFormat {
    public String jsonFormat(String resourceJsonStr) {
        String resultStr = "";
        if (StringUtils.hasText(resourceJsonStr)) {
            JSONArray jsonArray = JSON.parseArray(resourceJsonStr);

            // Parent初始化
            ProjectsParent projectsParent = null;
            ManagersParent managersParent = null;
            LogsParent logsParent = null;
            ProjectFeatureParent projectFeatureParent = null;

            // 一级列表初始化
            List<Object> projectChildrenList = new ArrayList<>();
            List<ProjectFeatureChildren> projectFeatureChildrenList = new ArrayList<>();
            List<ManagersChildren> managerChildrenList = new ArrayList<>();
            List<LogsChildren> logsChildrenList = new ArrayList<>();

            // 汇总结果初始化
            List<Object> resultList = new ArrayList<>();

            for (int i = 0; i < jsonArray.size(); i++) {
                if (jsonArray.get(i) instanceof JSONObject) {
                    // JSONObject
                    String feature_name_en = ((JSONObject) jsonArray.get(i)).get("feature_name_en").toString();
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    switch (feature_name_en) {
                        case "Projects":
                            projectsParent = new ProjectsParent();
                            projectsParent.setId(Integer.valueOf(jsonObject.get("id").toString()));
                            projectsParent.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                            projectsParent.setProject_name(jsonObject.get("project_name").toString());
                            projectsParent.setFeature_name(jsonObject.get("feature_name").toString());
                            projectsParent.setFeature_name_en(jsonObject.get("feature_name_en").toString());
                            projectsParent.setUrl_tag(jsonObject.get("url_tag").toString());
                            break;
                        case "Managers":
                            managersParent = new ManagersParent();
                            managersParent.setId(Integer.valueOf(jsonObject.get("id").toString()));
                            managersParent.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                            managersParent.setProject_name(jsonObject.get("project_name").toString());
                            managersParent.setFeature_name(jsonObject.get("feature_name").toString());
                            managersParent.setFeature_name_en(jsonObject.get("feature_name_en").toString());
                            managersParent.setUrl_tag(jsonObject.get("url_tag").toString());
                            break;
                        case "Logs":
                            logsParent = new LogsParent();
                            logsParent.setId(Integer.valueOf(jsonObject.get("id").toString()));
                            logsParent.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                            logsParent.setProject_name(jsonObject.get("project_name").toString());
                            logsParent.setFeature_name(jsonObject.get("feature_name").toString());
                            logsParent.setFeature_name_en(jsonObject.get("feature_name_en").toString());
                            logsParent.setUrl_tag(jsonObject.get("url_tag").toString());
                            break;
                    }
                } else {
                    // JSONArray
                    JSONArray jsonArray1 = (JSONArray) jsonArray.get(i);
                    if (jsonArray1.get(0) instanceof JSONObject) {
                        // managers/logs
                        JSONObject jsonObject = (JSONObject) jsonArray1.get(0);
                        String url_tag = jsonObject.get("url_tag").toString();
                        String one_name_en = jsonObject.get("one_name_en").toString();
                        if (url_tag.startsWith("/projects")) {
                            if (!one_name_en.equals("ProjectFeature")) {
                                // 非ProjectFeature
                                ProjectsChildren projectsChildren = new ProjectsChildren();
                                projectsChildren.setId(Integer.valueOf(jsonObject.get("id").toString()));
                                projectsChildren.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                                projectsChildren.setProject_name(jsonObject.get("project_name").toString());
                                projectsChildren.setFeature_id(Integer.valueOf(jsonObject.get("feature_id").toString()));
                                projectsChildren.setFeature_name(jsonObject.get("feature_name").toString());
                                projectsChildren.setOne_name(jsonObject.get("one_name").toString());
                                projectsChildren.setOne_name_en(jsonObject.get("one_name_en").toString());
                                projectsChildren.setUrl_tag(jsonObject.get("url_tag").toString());

                                projectChildrenList.add(projectsChildren);// 添加到组
                            } else {
                                // ProjectFeature
                                projectFeatureParent = new ProjectFeatureParent();
                                projectFeatureParent.setId(Integer.valueOf(jsonObject.get("id").toString()));
                                projectFeatureParent.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                                projectFeatureParent.setProject_name(jsonObject.get("project_name").toString());
                                projectFeatureParent.setFeature_id(Integer.valueOf(jsonObject.get("feature_id").toString()));
                                projectFeatureParent.setFeature_name(jsonObject.get("feature_name").toString());
                                projectFeatureParent.setOne_name(jsonObject.get("one_name").toString());
                                projectFeatureParent.setOne_name_en(jsonObject.get("one_name_en").toString());
                                projectFeatureParent.setUrl_tag(jsonObject.get("url_tag").toString());

                                projectChildrenList.add(projectFeatureParent);// 添加到组
                            }
                        } else if (url_tag.startsWith("/manage")) {
                            ManagersChildren managersChildren = new ManagersChildren();
                            managersChildren.setId(Integer.valueOf(jsonObject.get("id").toString()));
                            managersChildren.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                            managersChildren.setProject_name(jsonObject.get("project_name").toString());
                            managersChildren.setFeature_id(Integer.valueOf(jsonObject.get("feature_id").toString()));
                            managersChildren.setFeature_name(jsonObject.get("feature_name").toString());
                            managersChildren.setOne_name(jsonObject.get("one_name").toString());
                            managersChildren.setOne_name_en(jsonObject.get("one_name_en").toString());
                            managersChildren.setUrl_tag(jsonObject.get("url_tag").toString());

                            managerChildrenList.add(managersChildren);// 添加到组
                        } else if (url_tag.startsWith("/logs")) {
                            LogsChildren logsChildren = new LogsChildren();
                            logsChildren.setId(Integer.valueOf(jsonObject.get("id").toString()));
                            logsChildren.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                            logsChildren.setProject_name(jsonObject.get("project_name").toString());
                            logsChildren.setFeature_id(Integer.valueOf(jsonObject.get("feature_id").toString()));
                            logsChildren.setFeature_name(jsonObject.get("feature_name").toString());
                            logsChildren.setOne_name(jsonObject.get("one_name").toString());
                            logsChildren.setOne_name_en(jsonObject.get("one_name_en").toString());
                            logsChildren.setUrl_tag(jsonObject.get("url_tag").toString());

                            logsChildrenList.add(logsChildren);// 添加到组
                        }
                    } else {
                        // 含二级子节点(项目功能列表)
                        JSONArray jsonArray2 = (JSONArray) jsonArray1.get(0);
                        JSONObject jsonObject = (JSONObject) jsonArray2.get(0);
                        ProjectFeatureChildren projectFeatureChildren = new ProjectFeatureChildren();
                        projectFeatureChildren.setId(Integer.valueOf(jsonObject.get("id").toString()));
                        projectFeatureChildren.setProject_id(Integer.valueOf(jsonObject.get("project_id").toString()));
                        projectFeatureChildren.setProject_name(jsonObject.get("project_name").toString());
                        projectFeatureChildren.setFeature_id(Integer.valueOf(jsonObject.get("feature_id").toString()));
                        projectFeatureChildren.setFeature_name(jsonObject.get("feature_name").toString());
                        projectFeatureChildren.setOne_name(jsonObject.get("one_name").toString());
                        projectFeatureChildren.setTwo_name(jsonObject.get("two_name").toString());
                        projectFeatureChildren.setTwo_name_en(jsonObject.get("two_name_en").toString());
                        projectFeatureChildren.setUrl_tag(jsonObject.get("url_tag").toString());

                        projectFeatureChildrenList.add(projectFeatureChildren);// 添加到组
                    }
                }
            }

            // 汇总结果
            if (!projectChildrenList.isEmpty()) {
                projectsParent.setChildren(projectChildrenList);
            }
            if (!projectFeatureChildrenList.isEmpty()) {
                projectFeatureParent.setChildren(projectFeatureChildrenList);
            }
            if (!managerChildrenList.isEmpty()) {
                managersParent.setChildren(managerChildrenList);
            }
            if (!logsChildrenList.isEmpty()) {
                logsParent.setChildren(logsChildrenList);
            }

            resultList.add(projectsParent);
            resultList.add(managersParent);
            resultList.add(logsParent);

            resultStr = JSON.toJSONString(resultList, SerializerFeature.DisableCircularReferenceDetect);

            resultStr.replace("/", "\\/");

        }
        return resultStr;

    }

}

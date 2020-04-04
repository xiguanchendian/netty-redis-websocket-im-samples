package com.hitencent.samples;

import com.hitencent.samples.jsonFormat.JsonFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonFormatTest {

    @Autowired
    private JsonFormat jsonFormat;

    @Test
    public void jsonFormatTest() {
        String permission = "[{\"id\":8,\"project_id\":1,\"project_name\":\"Control\",\"feature_name\":\"项目\",\"feature_name_en\":\"Projects\",\"url_tag\":\"#\",\"permission_level\":1},[{\"id\":1,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":8,\"feature_name\":\"项目\",\"one_name\":\"项目列表\",\"one_name_en\":\"ProjectList\",\"url_tag\":\"\\/projects\\/projectlist\",\"permission_level\":1}],[{\"id\":2,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":8,\"feature_name\":\"项目\",\"one_name\":\"添加项目\",\"one_name_en\":\"AddProject\",\"url_tag\":\"\\/projects\\/addproject\",\"permission_level\":1}],[{\"id\":3,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":8,\"feature_name\":\"项目\",\"one_name\":\"项目功能\",\"one_name_en\":\"ProjectFeature\",\"url_tag\":\"\\/projects\\/projectfeatures\",\"permission_level\":1}],[[{\"id\":1,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":8,\"feature_name\":\"项目\",\"one_id\":3,\"one_name\":\"项目功能\",\"two_name\":\"功能列表\",\"two_name_en\":\"FeatureList\",\"url_tag\":\"\\/projects\\/projectfeatures\\/projectfeaturs_list\",\"permission_level\":1}]],[[{\"id\":2,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":8,\"feature_name\":\"项目\",\"one_id\":3,\"one_name\":\"项目功能\",\"two_name\":\"添加功能\",\"two_name_en\":\"AddFeature\",\"url_tag\":\"\\/projects\\/projectfeatures\\/projectfeaturs_add\",\"permission_level\":1}]],{\"id\":9,\"project_id\":1,\"project_name\":\"Control\",\"feature_name\":\"管理员\",\"feature_name_en\":\"Managers\",\"url_tag\":\"#\",\"permission_level\":0},[{\"id\":4,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":9,\"feature_name\":\"管理员\",\"one_name\":\"管理员列表\",\"one_name_en\":\"ManagerList\",\"url_tag\":\"\\/manage\\/managelist\",\"permission_level\":3}],[{\"id\":5,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":9,\"feature_name\":\"管理员\",\"one_name\":\"添加管理员\",\"one_name_en\":\"AddManager\",\"url_tag\":\"\\/manage\\/addmanage\",\"permission_level\":2}],{\"id\":11,\"project_id\":1,\"project_name\":\"Control\",\"feature_name\":\"日志\",\"feature_name_en\":\"Logs\",\"url_tag\":\"#\",\"permission_level\":1},[{\"id\":8,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":11,\"feature_name\":\"日志\",\"one_name\":\"登陆记录\",\"one_name_en\":\"LoginRecord\",\"url_tag\":\"\\/logs\\/loginrecord\",\"permission_level\":1}],[{\"id\":9,\"project_id\":1,\"project_name\":\"Control\",\"feature_id\":11,\"feature_name\":\"日志\",\"one_name\":\"查看记录\",\"one_name_en\":\"ActionRecord\",\"url_tag\":\"\\/logs\\/viewrecord\",\"permission_level\":1}]]";
        String permission_result = jsonFormat.jsonFormat(permission);

        System.out.println(permission_result);
    }
}

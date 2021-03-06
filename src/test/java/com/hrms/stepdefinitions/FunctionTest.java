package com.hrms.stepdefinitions;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.DbUtils;

import java.util.List;
import java.util.Map;

public class FunctionTest {
    public static void main(String[] args) {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String query="select * from ohrm_location";
        List<Map<String,String>> list=DbUtils.getDbDataIntoList(null);
        System.out.println(list);
        System.out.println(list.size());
    }
}

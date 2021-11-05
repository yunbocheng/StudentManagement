package com.yunbocheng.utils;

import com.yunbocheng.service.IService;
import com.yunbocheng.service.ServiceImpl;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        IService service = new ServiceImpl();
        List<Map<String, Object>> maps = service.roomAndCount();
        JSONArray jsons = JSONArray.fromObject(maps);
        System.out.println(jsons);
    }
}

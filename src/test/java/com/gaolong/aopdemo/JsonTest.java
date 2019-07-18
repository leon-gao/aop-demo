package com.gaolong.aopdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

public class JsonTest {

    public static void main(String[] args) {

        List<String> list = JSON.parseArray("[{\"age\":\"30\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gl\"}]", String.class);

        JSONArray array = JSONArray.parseArray("[{\"age\":\"30\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gl\"}]");


//        for (String str:strList) {
//            System.out.println(str);
//        }

    }
}

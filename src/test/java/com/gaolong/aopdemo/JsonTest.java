package com.gaolong.aopdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

public class JsonTest {

    public static void main(String[] args) {

//        List<String> list = JSON.parseArray("[{\"age\":\"30\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gl\"}]", String.class);
//
//        JSONArray array = JSONArray.parseArray("[{\"age\":\"30\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gl\"}]");

        // 以下是初始数据
        String str1 = "[{\"age\":\"30\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gl\"}]";
        String str2 = "[{\"age\":\"40\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gf\"}]";
        String str3 = "[{\"age\":\"50\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gl\"}]";
        String str4 = "[{\"age\":\"60\",\"dept\":\"dev\",\"gender\":\"men\",\"name\":\"gf\"}]";
        String str5 = "[{\"age\":\"70\",\"dept\":\"test\",\"gender\":\"men\",\"name\":\"jjj\"}]";
        String str6 = "[{\"age\":\"80\",\"dept\":\"ops\",\"gender\":\"men\",\"name\":\"sj\"}]";


        List<String> ts = Arrays.asList(str1, str2, str3, str4, str5, str6);

        /**
         * 遍历结果集，使用redis俩俩进行对比，获取diff集合
         * 比如：1与2对比，2与3对比，3与4对比......
         *
         * PS：有一个问题：获取分页的10条记录，只能产生9条对比记录，建议在精确检索时（根据修改的ID，如员工ID或者部门ID）不进行分页（会有查询效率慢的问题，需要进行测试）
         * 另一个问题：如何初始化第一条数据
         *
         */
        for (int i=0; i<ts.size(); i++) {

            // 分割JSON字符串
            String[] strs = null;
            if (strs == null) {
                strs = ts.get(i).replace("[{","").replace("}]","").split(",");
                // 将分割后的字符串数组set到redis中
//            redisTemplate.opsForSet().add(i, strs);
            }



            for (int j=i+1; j<ts.size(); j++) {

                // 对第二条数据进行分割，将分割后的字符串数组set到redis中
                strs = ts.get(j).replace("[{","").replace("}]","").split(",");

//                redisTemplate.opsForSet().add(j, strs);
//                redisTemplate.opsForSet().differenceAndStore(i, j , "diff"+j);
//                Set<String> diffSet = redisTemplate.opsForSet().members("diff"+j);

                StringBuilder stringBuilder = new StringBuilder();
//                for (String str : diffSet) {
//
//                    String key = str.split(":")[0];
//                    String value = str.split(":")[1];
//
//                    Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("updateBykey");
//
//                    if (map != null) {
//                        String modifyDesc = map.get(key).toString();
//                        stringBuilder.append("入库    "+modifyDesc + "->" + value);
//                    }
//
//                }

                System.out.println("compare:" + ts.get(i) + "->" + ts.get(j));
                break;
            }

        }

        // for
        // 删除Redis
//                    redisTemplate.delete(userId + operationLog.getMethod());
//                    System.out.println("删除Redis"+userId + operationLog.getMethod());
//
//                    redisTemplate.delete(userId + operationLog.getMethod()+"modify");
//                    System.out.println("删除Redis"+userId + operationLog.getMethod()+"modify");

    }
}

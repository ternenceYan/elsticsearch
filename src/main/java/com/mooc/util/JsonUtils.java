package com.mooc.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import com.mooc.enums.ErrorCode;
import com.mooc.exceptions.BaseException;

import java.lang.reflect.Type;
public class JsonUtils {

    public static void test () {
        String jsonStr = "{\"UID\":\"f294467b84724a7599f57dec71f0583a\",\"ORDERINFO\":{\"ORDERDATE\":\"2019-05-24 14:08:03\",\"ORDERNO\":\"190524140803957010984\"},\"VERSION\":\"2.0.0\",\"RESULTDATA\":[{\"SCORE_SFSG\":\"0.778\",\"SCORE_SFTZ\":\"0.668\",\"SCORE_FZQL\":\"0.66\",\"SCORE\":\"646\",\"SCOREDATE\":\"20190331\",\"RATING\":\"BBB\",\"SCORE_JYQK\":\"0.873\",\"SCORE_XWTX\":\"0.694\",\"SCORE_CXZZ\":\"0.592\"},{\n" +
                "            \"SCORE_SFSG\":\"0.111\",\n" +
                "            \"SCORE_SFTZ\":\"111\",\n" +
                "            \"SCORE_FZQL\":\"0.66\",\n" +
                "            \"SCORE\":\"111\",\n" +
                "            \"SCOREDATE\":\"20190331\",\n" +
                "            \"RATING\":\"BBB\",\n" +
                "            \"SCORE_JYQK\":\"0.873\",\n" +
                "            \"SCORE_XWTX\":\"0.694\",\n" +
                "            \"SCORE_CXZZ\":\"0.592\"\n" +
                "        }]}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        JSONArray jsonArray = (JSONArray)jsonObject.get("RESULTDATA");
        if (jsonArray.size() > 0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject1 = (JSONObject)jsonArray.get(i);
                String score = jsonObject1.get("SCORE").toString();
                System.out.println(score);
            }
        }

    }

    private static Gson gson = new Gson();

    public static <T> T fromJson (String jsonStr, Class<T> cls) {
        try {
            return gson.fromJson(jsonStr,cls);
        } catch (Exception e) {
            throw new BaseException(ErrorCode.JSON_ERROR);
        }
    }

    public static <T> T fromJson (String jsonStr, Type type) {

        try {
            return gson.fromJson(jsonStr,type);
        } catch (Exception e) {
            throw new BaseException(ErrorCode.JSON_ERROR);
        }
    }

    public static String toJson (Object object) {
        try {
            return gson.toJson(object);
        } catch (Exception e) {
            throw new BaseException(ErrorCode.JSON_ERROR);
        }
    }

    public static void main(String[] args) {
        test();
    }
}

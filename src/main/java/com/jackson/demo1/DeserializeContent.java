package com.jackson.demo1;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.demo1.dc.AggregateResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DeserializeContent {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        //解析RT_DC
        deseriazeDC("/RT_DC.txt");
        //解析RT_LS,个人业务
//        deseriazeLS("/data/RT_LS.txt");
        //解析RT_DG，对公业务
//        deseriazeDG("/data/RT_DG.txt");

    }

    /**
     * 解析DC数据
     *
     * @param filePath
     * @throws Exception
     */
    public static void deseriazeDC(String filePath) throws Exception {
        String content = FileUtils.readFileToString(new File(filePath));

        JavaType javaType = objectMapper.getTypeFactory()
                .constructParametricType(ArrayList.class, AggregateResult.class);

        List<AggregateResult> queryResult = objectMapper.readValue(content, javaType);
        System.out.println(queryResult);
    }

    /**
     * 解析LS数据
     *
     * @param filePath
     * @throws Exception
     */
//    public static void deseriazeLS(String filePath) throws Exception {
//        String content = FileUtils.readFileToString(new File(filePath));
//        GJQueryResult queryResult = objectMapper.readValue(content, GJQueryResult.class);
//        System.out.println(queryResult);
//    }
//
//    /**
//     * 解析DG数据
//     *
//     * @param filePath
//     * @throws Exception
//     */
//    public static void deseriazeDG(String filePath) throws Exception {
//        String content = FileUtils.readFileToString(new File(filePath));
//        DGQueryResultNew queryResult = objectMapper.readValue(content, DGQueryResultNew.class);
//        System.out.println(queryResult);
//    }
}

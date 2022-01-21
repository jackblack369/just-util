package com.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Demo {

    public static void main(String[] args) throws Exception{
        QueryResult queryResult = QueryResult.builder()
                .PROD_CODE("123")
                .PROD_NAME("name_a")
                .build();
        System.out.println(queryResult);
//        string2Map();
    }

    public static void string2Map() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String content = "    {\n" +
                "      \"columnName\": \"others\",\n" +
                "      \"columnType\": \"DECIMAL\",\n" +
                "      \"defaultValue\": \"\"\n" +
                "    }";
        Map resultMap = objectMapper.readValue(content, Map.class);
        System.out.println(resultMap);

        System.out.println(resultMap.get("columnName"));

    }
}

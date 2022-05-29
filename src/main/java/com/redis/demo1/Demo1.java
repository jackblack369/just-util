package com.redis.demo1;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.File;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("localhost");
//        String content = FileUtils.readFileToString(new File("/data/ZetYun/PROJECT_LINYI/linyi_rt_mock/src/main/resources/data/dcLinYiRaw.json"));
        String content = FileUtils.readFileToString(new File("/data/ZetYun/PROJECT_LINYI/linyi_rt_mock/src/main/resources/server/content.txt"));
        jedis.set("RT_DC",content);
        jedis.close();
    }

    @Test
    public void test1(){
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println(jedis.hget("wednesday", "monday"));
        jedis.close();
    }

}

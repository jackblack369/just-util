package com.redis.demo1;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    }


    @Test
    public void test2() throws IOException {
        String content = FileUtils.readFileToString(new File("/Users/dongwei/datacanvas/doc_project/莱商银行/问题排查/20230128-大屏交易笔数忽高忽低/大屏后端实时数据/RT_DC.txt"),"UTF-8");
//        System.out.println(content);
        Jedis jedis = new Jedis("localhost");
        jedis.select(0);
        System.out.println(jedis.set("RT_DC",content));
        jedis.close();
    }

    @Test
    public void test1() {
        Jedis jedis = new Jedis("127.0.0.1");
//        System.out.println(jedis.hget("wednesday", "monday"));
//        System.out.println(jedis.hgetAll("week"));
        int cursor = 0;
        ScanParams scanParams = new ScanParams().match("*").count(10);

        ScanResult<Map.Entry<String, String>> scanResult = jedis.hscan("week", String.valueOf(cursor), scanParams);

//            System.out.println("scan size:" + scanResult.getResult());
//            for (Map.Entry<String, String> e : scanResult.getResult()) {
//                System.out.println(e.getKey() + ":" + e.getValue());
//            }
            int count = 0;
            Iterator<Map.Entry<String, String>> iterator =  scanResult.getResult().iterator();
            while(iterator.hasNext()){
                if(count==5 ) break;
                Map.Entry<String, String> e = iterator.next();
                System.out.println(e.getKey() + ":" + e.getValue());
                count++;
            }
            //获取游标位置，若大于0，则代表还有数据，需要继续迭代
            cursor = Integer.parseInt(scanResult.getStringCursor());
            System.out.println("cursor:"+cursor);
        jedis.close();
    }

}

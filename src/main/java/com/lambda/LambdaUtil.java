package com.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author dongwei
 * 2018/8/23 14:14
 **/
@Slf4j
public class LambdaUtil {

    @Test
    public void test1(){
        log.info("test1");
        /**
         *      .forEach(imageList::add);
         *          等同于
         *      .forEach(item -> imageList.add(item));
         */

    }
}

package com.encryption;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;

public class JasyptUtil {

    @Test
    public void test() {
        String jdbcPassword = "3S8NDhEHbtA6vTrHcO0N42kb/rZuv2u0";
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("e9fbdb2d3b21");
        jdbcPassword = textEncryptor.decrypt(jdbcPassword);
        System.out.println(jdbcPassword);
    }
}

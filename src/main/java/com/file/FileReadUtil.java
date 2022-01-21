package com.file;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

@Slf4j
public class FileReadUtil {

    @Test
    public void readMd5() {
        String filePath = "/data/mock/test.ok";
        byte[] fileContent = readByte(filePath);
        String encoding = "UTF-8";
        try {
            System.out.println(new String(fileContent, encoding).split(" ")[4]);
        } catch (UnsupportedEncodingException e) {
            log.error("The OS does not support " + encoding, e);
        }
    }

    public static byte[] readByte(String filePath) {
        File file = new File(filePath);
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try(FileInputStream in = new FileInputStream(file)) {
            in.read(fileContent);
        } catch (Exception e) {
//            log.error("Read [{}] failed, msg is [{}].", filePath, e.getMessage(), e);
        }
        return fileContent;
    }
}

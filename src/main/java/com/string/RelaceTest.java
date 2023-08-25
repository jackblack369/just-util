package com.string;

import org.junit.Test;

import java.util.Random;

public class RelaceTest {
        public static void main(String[] args) {
            String originalString = "abcdefgh";
            String replacement = "12345";

            String replacedString = replaceSubstring(originalString, replacement, 2, 6);
            System.out.println(replacedString);  // 输出：ab12345gh
        }

        public static String replaceSubstring(String original, String replacement, int startIndex, int endIndex) {
            String prefix = original.substring(0, startIndex);
            String suffix = original.substring(endIndex);
            return prefix + replacement + suffix;
        }

        @Test
        public void test1(){
            System.out.println(new Random().nextInt(3));
        }

}

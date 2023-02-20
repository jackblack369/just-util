package com.number;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BigDecimalTest {

    public static void main(String[] args) {
//        System.out.println(computeAMP(new BigDecimal("100"), new BigDecimal("1000")));
//        billionCompute();
        testZero();
    }

    /**
     * 计算百分比
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static BigDecimal computeAMP(BigDecimal dividend, BigDecimal divisor) {
        if (divisor.compareTo(BigDecimal.ZERO) == 0) {
            if (dividend.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            } else {
                return dividend.abs().compareTo(dividend) == 0 ? new BigDecimal("100") : new BigDecimal("-100");
            }
        } else {
            return dividend
                    .multiply(new BigDecimal("100"))
                    .divide(divisor, 4, RoundingMode.HALF_UP);
        }
    }

    /**
     * 单位换算
     */
    public static void billionCompute(){
        // 具体的注册资本等信息（单位元）
        String price = "50000088888";
        BigDecimal bigDecimal = new BigDecimal(price);
        // 转换为万元（除以10000）
        BigDecimal decimal = bigDecimal.divide(new BigDecimal("100000000"));
        // 保留两位小数
        DecimalFormat formater = new DecimalFormat("0.00");
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);    // 5000008.89
//        formater.setRoundingMode(RoundingMode.HALF_DOWN);// 5000008.89
//        formater.setRoundingMode(RoundingMode.HALF_EVEN);

        // 格式化完成之后得出结果
        String formatNum = formater.format(decimal);
        System.out.println(formatNum);
    }

    /**
     * 去掉小数点后面多余的0
     */
    public static void testZero() {
        BigDecimal value = new BigDecimal("1.00");
        BigDecimal noZeros = value.stripTrailingZeros();
        String result = noZeros.toPlainString();
        System.out.println("result: " + result);
    }

    @Test
    public void testCompare(){
        BigDecimal a = new BigDecimal("2000");
        BigDecimal b = new BigDecimal("2000");
        System.out.println(a.compareTo(b));
    }
}

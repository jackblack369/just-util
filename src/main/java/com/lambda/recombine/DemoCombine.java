package com.lambda.recombine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoCombine {

    public static void main(String[] args) {
        recombine(genResult());
    }

    public static CustRankResult2 genResult(){

        CustRankOpun2 root = CustRankOpun2.builder()
                .OPUN_COD("9100000000")
                .RPT_MANAGE_BRH("900000000")
                .LIST_CUST(genRoot())
                .build();

        CustRankOpun2 jinna = CustRankOpun2.builder()
                .OPUN_COD("9103000000")
                .RPT_MANAGE_BRH("9100000000")
                .LIST_CUST(genJinan())
                .build();

        CustRankOpun2 rizhao = CustRankOpun2.builder()
                .OPUN_COD("9101000000")
                .RPT_MANAGE_BRH("9100000000")
                .LIST_CUST(genRizhao())
                .build();

        return CustRankResult2.builder()
                .LIST_OPUN(Arrays.asList(root, jinna, rizhao)).build();
    }

    public static List<CustInfo2> genRoot() {
        CustInfo2 root_1 = CustInfo2.builder()
                .custName("root-收-甲")
                .custNo("001")
                .tradeAmt(new BigDecimal(1000))
                .tradeType("0")
                .build();

        CustInfo2 root_2 = CustInfo2.builder()
                .custName("root-收-乙")
                .custNo("002")
                .tradeAmt(new BigDecimal(2000))
                .tradeType("0")
                .build();

        CustInfo2 root_3 = CustInfo2.builder()
                .custName("root-付-甲")
                .custNo("003")
                .tradeAmt(new BigDecimal(1000))
                .tradeType("1")
                .build();

        CustInfo2 root_4 = CustInfo2.builder()
                .custName("root-付-乙")
                .custNo("004")
                .tradeAmt(new BigDecimal(2000))
                .tradeType("1")
                .build();

        return Arrays.asList(root_1,root_2,root_3,root_4);
    }

    public static List<CustInfo2> genJinan() {
        CustInfo2 jinan_1 = CustInfo2.builder()
                .custName("jinan-收-甲")
                .custNo("001")
                .tradeAmt(new BigDecimal(1000))
                .tradeType("0")
                .build();

        CustInfo2 jinan_2 = CustInfo2.builder()
                .custName("jinan-收-乙")
                .custNo("002")
                .tradeAmt(new BigDecimal(2000))
                .tradeType("0")
                .build();

        CustInfo2 jinan_3 = CustInfo2.builder()
                .custName("jinan-付-甲")
                .custNo("003")
                .tradeAmt(new BigDecimal(1000))
                .tradeType("1")
                .build();

        CustInfo2 jinan_4 = CustInfo2.builder()
                .custName("jinan-付-乙")
                .custNo("004")
                .tradeAmt(new BigDecimal(2000))
                .tradeType("1")
                .build();

        CustInfo2 jinan_5 = CustInfo2.builder()
                .custName("jinan-付-丙")
                .custNo("005")
                .tradeAmt(new BigDecimal(3000))
                .tradeType("1")
                .build();

        return Arrays.asList(jinan_1,jinan_2,jinan_3,jinan_4,jinan_5);
    }

    public static List<CustInfo2> genRizhao() {
        CustInfo2 rz_1 = CustInfo2.builder()
                .custName("rz-收-甲")
                .custNo("005")
                .tradeAmt(new BigDecimal(1000))
                .tradeType("0")
                .build();

        CustInfo2 rz_2 = CustInfo2.builder()
                .custName("rz-收-乙")
                .custNo("006")
                .tradeAmt(new BigDecimal(2000))
                .tradeType("0")
                .build();

        CustInfo2 rz_3 = CustInfo2.builder()
                .custName("rz-付-甲")
                .custNo("007")
                .tradeAmt(new BigDecimal(1000))
                .tradeType("1")
                .build();

        CustInfo2 rz_4 = CustInfo2.builder()
                .custName("rz-付-乙")
                .custNo("008")
                .tradeAmt(new BigDecimal(2000))
                .tradeType("1")
                .build();

        CustInfo2 rz_5 = CustInfo2.builder()
                .custName("jinan-付-丙")
                .custNo("005")
                .tradeAmt(new BigDecimal(3000))
                .tradeType("1")
                .build();

        return Arrays.asList(rz_1,rz_2,rz_3,rz_4, rz_5);
    }


    private static CustRankResult2 recombine(CustRankResult2 queryResult) {
        List<CustRankOpun2> branchOpuns = queryResult.getLIST_OPUN()
                .stream().filter(opun -> opun.getRPT_MANAGE_BRH().equals("9100000000"))
                .filter(opun -> opun.getLIST_CUST()!=null)
                .collect(Collectors.toList());

        List<List<CustInfo2>> branchCusts = branchOpuns.stream().map(opun -> opun.getLIST_CUST())
                .collect(Collectors.toList());

//        System.out.println("branchCusts:"+branchCusts);

        List<CustInfo2> fuCusts = branchCusts
                .stream()
                .flatMap(List::stream)
                .filter(cust -> cust.getTradeType().equals("1"))
                .filter(distinctByKey(CustInfo2::unionKey))
                .sorted(Comparator.comparing(CustInfo2::getTradeAmt).reversed())
                .limit(3)
                .collect(Collectors.toList());

//        System.out.println("fuCust:{}"+ fuCusts);
//
        List<CustInfo2> shouCusts = branchCusts
                .stream()
                .flatMap(List::stream)
                .filter(cust -> cust.getTradeType().equals("0"))
                .filter(distinctByKey(CustInfo2::unionKey))
                .sorted(Comparator.comparing(CustInfo2::getTradeAmt).reversed())
                .limit(3)
                .collect(Collectors.toList());
//
        List<CustInfo2> topCusts = Stream.of(fuCusts,shouCusts)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        queryResult.getLIST_OPUN().stream()
                .filter(opun -> opun.getOPUN_COD().equals("9100000000"))
                .findFirst()
                .get().setLIST_CUST(topCusts);

        System.out.println(queryResult);
        return queryResult;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}

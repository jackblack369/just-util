package com.lambda.recombine;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DeduplicationByKey {

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

    CustInfo2 root_5 = CustInfo2.builder()
            .custName("root-付-乙")
            .custNo("004")
            .tradeAmt(new BigDecimal(3000))
            .tradeType("1")
            .build();

    List<CustInfo2> originCust = Arrays.asList(root_1, root_2,  root_4,root_5, root_3);


    @Test
    public void test1() {

        List<CustInfo2> resultCust = originCust
                .stream()
                .filter(cust -> cust.getTradeType().equals("1"))
                .sorted(Comparator.comparing(CustInfo2::getTradeAmt).reversed())
                .filter(distinctByKey(CustInfo2::deduplicateByKey))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(resultCust);
    }

    public <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}


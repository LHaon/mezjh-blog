package com.mezjh.blog.play.test;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ZJH
 * @date 2021/7/1 18:21
 */
public class Test {
    public static void main(String[] args) throws Exception {

    }

    public static void test(List<AwT> awTS) {
        Map<String, List<AwT>> stringListMap = awTS.stream().collect(Collectors.groupingBy(AwT::getName));
        stringListMap.keySet().forEach(x -> {
            List<AwT> awTS1 = stringListMap.get(x);
            Integer max = awTS1.stream().mapToInt(AwT::getAge).max().getAsInt();
            awTS1.forEach(y -> y.setAge(max));
        });
    }
}

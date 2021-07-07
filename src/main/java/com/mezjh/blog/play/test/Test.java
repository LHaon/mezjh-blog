package com.mezjh.blog.play.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZJH
 * @date 2021/7/1 18:21
 */
public class Test {
    public static void main(String[] args) {
        Map<String, AwT> map = new HashMap<>();
        map.put("1", new AwT(1330000L));
        map.put("2", new AwT(1990000L));
        map.forEach((k, v) -> v.setAmount(v.getAmount() / 1000000));
    }
}

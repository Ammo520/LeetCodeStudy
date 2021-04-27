package day1;

import java.util.*;

/**
 * @author Liao wenbo
 * @className 根据字符出现频率排序
 * @date 2020/4/12
 */
public class 根据字符出现频率排序 {
    public static String frequencySort(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = s.split("");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            Integer val = map.get(split[i]) == null ? 1 : map.get(split[i]) + 1;
            map.put(split[i], val);
            if (val > max) {
                max = val;
            }
        }
        String[] list = new String[max + 1];
        for (String key : map.keySet()) {
            Integer num = map.get(key);
            String res = list[num];
            StringBuilder val = new StringBuilder();
            for (int i = 0; i < num; i++) {
                val.append(key);
            }
            if (res == null) {
                list[num] = val.toString();
            } else {
                list[num] = val + res;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null) {
                result.append(list[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String tree = frequencySort("fgthrthgergfawsfgghtyjdehgryjyuio");
        char s = 30000;
        System.out.println(s);
        System.out.println(tree);
    }
}

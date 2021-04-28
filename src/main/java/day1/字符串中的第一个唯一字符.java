package day1;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Liao wenbo
 * @className 相交链表
 * @date 2020/4/12
 */
public class 字符串中的第一个唯一字符 {
    public static int firstUniqChar1(String s) {
        if (s == null || s.equals("")) {
            return -1;
        }
        String[] split = s.split("");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < split.length; i++) {
            map.put(split[i], map.get(split[i]) == null ? 1 : map.get(split[i]) + 1);
        }
        for (String s1 : map.keySet()) {
            if (map.get(s1) == 1) {
                return s.indexOf(s1);
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        int temp = -1;
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            int lastIndexOf = s.lastIndexOf(i);
            if (index != -1 && index == lastIndexOf && (index < temp || temp == -1)) {
                temp = index;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        firstUniqChar1("leetcode");
    }

}



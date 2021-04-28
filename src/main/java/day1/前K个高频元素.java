package day1;

import java.util.*;

/**
 * @author Liao wenbo
 * @className 前K个高频元素
 * @date 2020/4/12
 */
public class 前K个高频元素 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = 1;
            if(map.containsKey(num)){
                val += map.get(num);
            }
            map.put(num, val);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] i = {1,1,1,2,2,3};
        List<Integer> integers = topKFrequent(i, 2);
        System.out.println(integers);
    }
}

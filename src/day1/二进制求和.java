package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liao wenbo
 * @className 二进制求和
 * @date 2020/4/12
 */
public class 二进制求和 {
    public static String addBinary1(String a, String b) {
        String[] s1 = a.split("");
        String[] s2 = b.split("");
        StringBuilder res = new StringBuilder();
        int length = s1.length >= s2.length ? s1.length : s2.length;
        String[] sa;
        String[] sb;
        if (s1.length > s2.length) {
            sa = s1;
            sb = new String[s1.length];
            for (int i = 0; i < s2.length; i++) {
                sb[i + s1.length - s2.length] = s2[i];
            }
        } else {
            sa = new String[s2.length];
            sb = s2;
            for (int i = 0; i < s1.length; i++) {
                sa[i + s2.length - s1.length] = s1[i];
            }
        }
        int temp = 0;
        for (int i = length - 1; i >= 0; i--) {
            int x = 0;
            int y = 0;
            if (sa[i] != null) {
                x = Integer.parseInt(sa[i]);
            }
            if (sb[i] != null) {
                y = Integer.parseInt(sb[i]);
            }
            int num = x + y + temp;
            if (num > 1) {
                num = num - 2;
                res.insert(0, num);
                temp = 1;
            } else {
                res.insert(0, num);
                temp = 0;
            }
        }
        if (temp == 1) {
            res.insert(0, temp);
        }
        return res.toString();
    }

    public static String addBinary2(String a, String b) {
        StringBuffer sb1 = new StringBuffer(a).reverse();
        StringBuffer sb2 = new StringBuffer(b).reverse();
        int len1 = sb1.length();
        int len2 = sb2.length();
        int length = Math.max(len1, len2);
        boolean temp = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c1 = i >= len1 ? '0' : sb1.charAt(i);
            char c2 = i >= len2 ? '0' : sb2.charAt(i);
            if (c1 == '0' && c2 == '0') {
                result.append(temp?1:0);
                temp = false;
            } else if (c1 == '1' && c2 == '1') {
                result.append(temp?1:0);
                temp = true;
            } else {
                result.append(temp?0:1);
            }
        }
        if(temp){
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = addBinary2("11", "1");
        System.out.println(s);
    }
}

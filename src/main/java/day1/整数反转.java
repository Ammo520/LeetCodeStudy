package day1;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Liao wenbo
 * @className 整数反转
 * @date 2020/4/12
 */
public class 整数反转 {
    public static void main(String[] args) {
        int reverse = reverse2(-1534236469);
        System.out.println(reverse);
    }

    public static int reverse1(int x) {
        String[] split = Integer.toString(x).split("");
        String[] result = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            result[split.length - i - 1] = split[i];
        }
        String replace = Arrays.toString(result).replaceAll("[^0-9^-]", "");
        if (replace.contains("-")) {
            replace = "-" + replace.replace("-", "");
        }
        try {
            return Integer.parseInt(replace);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            if(result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10){
                return 0;
            }
            int temp = x % 10;
            result = result * 10 + temp;
            x = x / 10;
        }
        return result;
    }

}

package day1;

import lombok.Data;

/**
 * @author Liao wenbo
 * @className 加一
 * @date 2020/4/13
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        boolean carryBit = true;
        int sum = 0;
        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && carryBit) {
                result[i] = 0;
                sum++;
            } else {
                result[i] = digits[i] + (carryBit ? 1 : 0);
                carryBit = false;
            }
        }
        if (sum == digits.length) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = 0;
            }
        }
        return result;
    }
}

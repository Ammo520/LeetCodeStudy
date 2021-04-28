package day1;

/**
 * @author Liao wenbo
 * @className 颠倒二进制位
 * @date 2020/4/12
 */
public class 颠倒二进制位 {
    public static void main(String[] args) {
        int i = reverseBits1(10);
        System.out.println(i);
    }

    public static int reverseBits1(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }
}

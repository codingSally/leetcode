package binSearch;

import java.util.Arrays;

/**
 * @Description  二分答案题目
 * @Auther xueshangling
 * @Date 2024/11/2
 **/
public class BinSearch2 {

    public static void main(String[] args) {

    }

    // 69 X的平方根
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid == x) {
                return mid;
            }

            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 向下取整
        return left - 1;
    }

    // 287 寻找重复数
    // 方法一 二分
    public int findDuplicate(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);
        for (int i = 0; i < len - 1; i++) {
            int target = nums[i];

            int left = i + 1;
            int right = len - 1;
            while (left <= right) {
                int mid = left + (right - left + 1) / 2;

                if (nums[mid] == target) {
                    return nums[mid];
                }

                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    // 方法二 双指针
    public int findDuplicate2(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);
        int i = 0;
        int j = i + 1;
        while (i < len - 1) {
            if (nums[i] == nums[j]) {
                return nums[i];
            }

            i++;
            j++;
        }

        return -1;
    }

    // 50. Pow(x, n)
    // 方法一 暴力解法，超出时间限制
    public double myPow(double x, int n) {
        double result = 1;

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result *= x;
            }
        } else {
            for (int i = 0; i < Math.abs(n); i++) {
                result /= x;
            }
        }


        return result;
    }

    // 方法二 递归
    public double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if(N == 0) {
            return 1.0;
        }

        double y = quickMul(x, N /2);
        return N % 2 == 0 ? y *y :y * y * x;
    }

    // 367. 有效的完全平方数
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num /2 + 1;

        while(left <= right) {
            long mid = left +(right - left) /2;

            if(mid * mid == num) {
                return true;
            }

            if(mid * mid > num) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return false;
    }

    // 400. 第 N 位数字
    // 方法一 暴力解法，超出内存限制
    public int findNthDigit(int n) {
        StringBuffer sb = new StringBuffer();

        for(int i= 1; i <= n ; i ++) {
            sb.append(i);
        }

        return sb.toString().charAt(n-1) - '0';
    }

    // 方法二 递归
    public int findNthDigit2(int n) {
        return find(n, 10, 1);
    }

    int find(long n, long base, int i) {
        if(n >= base *i) {
            return find(n+ base, base * 10, i +1);
        }
        return String.valueOf(n/i).charAt((int)(n % i)) - '0';
    }
}

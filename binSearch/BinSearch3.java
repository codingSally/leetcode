package binSearch;

/**
 * @Description 复杂的二分查找问题
 * @Auther xueshangling
 * @Date 2024/11/2
 **/
public class BinSearch3 {

    public static void main(String[] args) {

    }

    // 875. 爱吃香蕉的珂珂
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int right = high;

        while (left <= right) {
            int speed = left + (right - left + 1) / 2;
            int allTime = getTime(piles, speed);

            if (allTime > h) {
                left = speed + 1;
            } else {
                right = speed - 1;
            }
        }

        return left;
    }

    private int getTime(int[] piles, int speed) {
        int allTime = 0;
        for (int pile : piles) {
            allTime += (pile + speed - 1) / speed;
        }

        return allTime;
    }

    // 2226. 每个小孩最多能分到多少糖果
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        int right = max;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            long count = getChildCount(candies, mid);
            if (count >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left - 1;
    }

    private long getChildCount(int[] candies, int mid) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
        }

        return count;
    }

    // 2064. 分配给商店的最多商品的最小值
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        int right = max;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            long count = getStoreCount(quantities, mid);
            if (count > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private long getStoreCount(int[] quantities, int mid) {
        long count = 0;
        for (int quantity : quantities) {
            count += (quantity + mid - 1) / mid;
        }

        return count;
    }

    // 410. 分割数组的最大值
    // 方法一 二分法
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            long count = getSplitCount(nums, mid);
            if (count > k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private long getSplitCount(int[] nums, int mid) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > mid) {
                count ++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return count;
    }

    // 209. 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len;
        int result = Integer.MAX_VALUE;

        int[] prefixArr = new int[len + 1];
        int sum = 0;
        for(int i =1; i < len + 1; i ++) {
            sum += nums[i -1];
            prefixArr[i] = sum;
        }

        while(left <= right) {
            int mid = left + (right-left + 1) /2;
            if(isLarger(prefixArr, target, mid)) {
                result = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return result != Integer.MAX_VALUE ? result : 0;
    }

    private boolean isLarger(int[] prefixArr, int target, int curLength) {
        if(prefixArr[curLength] >= target) {
            return true;
        }

        int len  = prefixArr.length;
        for(int i = curLength; i < len; i ++) {
            if(prefixArr[i] - prefixArr[i-curLength] >= target) {
                return true;
            }
        }

        return false;
    }
}

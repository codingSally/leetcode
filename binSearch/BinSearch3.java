package binSearch;

import java.util.*;

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

    // 658. 找到 K 个最接近的元素
    // 方法一 暴力法
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int[] absArr = new int[len];

        for (int i = 0; i < len; i++) {
            absArr[i] = Math.abs(arr[i] - x);
        }

        int index = 0;
        int min = Integer.MAX_VALUE;
        ;
        for (int i = 0; i <= len - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += absArr[i + j];
            }
            if (sum < min) {
                min = sum;
                index = i;
            }
        }

        List<Integer> finalList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            finalList.add(arr[index + i]);
        }

        return finalList;
    }

    // 287. 寻找重复数
    // 方法一  hash表
    public int findDuplicate1(int[] nums) {
        int len = nums.length;

        Set<Integer> temp = new HashSet<>();
        for(int i =0; i <len; i ++) {
            if(temp.contains(nums[i])) {
                return nums[i];
            }
            temp.add(nums[i]);
        }

        return -1;
    }

    // 方法二  暴力解法
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int i = 1;
        while(i < len) {
            if(nums[i] == nums[i-1]) {
                return nums[i];
            }

            i++;
        }

        return -1;
    }

    // 方法三 二分法
    public int findDuplicate3(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len -1;
        int ans = -1;

        while(left <= right) {
            int mid  = left +(right -left + 1 ) /2;
            int count = 0;

            for (int i =0; i <len; i ++) {
                if(nums[i] <= mid) {
                    count ++;
                }
            }

            if(count <= mid) {
                left = mid +1;
            } else {
                right = mid -1;
                ans = mid;
            }
        }

        return ans;
    }

    // 1011 在 D 天内送达包裹的能力
    // 二分法
    public int shipWithinDays(int[] weights, int days) {
        int len = weights.length;
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while(left <= right) {
            int mid = left + (right - left + 1) /2;
            int count = getCount(weights, mid);

            if(count > days) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }

        return left;
    }

    private int getCount(int[] weights, int curWei) {
        int count = 1;

        int sum = 0;
        for(int weight : weights) {
            if(sum + weight > curWei) {
                count ++;
                sum =0;
            }

            sum += weight;
        }

        return count;
    }

    // 1482 制作 m 束花所需的最少天数
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m > len / k) {
            return -1;
        }
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();

        while(left <= right) {
            int mid = left + (right - left + 1) /2;

            if(getCount(bloomDay, mid, m, k) >= m) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return left;
    }

    public int getCount(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets;
    }

}

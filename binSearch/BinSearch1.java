package binSearch;

import java.util.Arrays;

/**
 * @Description 二分下标题目
 * @Auther xueshangling
 * @Date 2024/11/2
 **/
public class BinSearch1 {

    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 4, 2, 2};
       // findDuplicate(test);
    }

    // 704 二分查找
    // 方法一 直接查找法
    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // 方法二 排除法
    public int search2(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return nums[left] == target ? left : -1;
    }

    // 374 猜数字游戏
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (guess(mid) <= 0) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }

        return left;
    }

    // 35 搜索插入位置
    // 方法一 直接查找法
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 方法二 排除法
    public int searchInsert2(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return nums[left] >= target ? left : left + 1;
    }

    // 34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                int i = mid + 1;
                while (i <= right && nums[i] == target) {
                    i++;
                }

                int j = mid - 1;
                while (j >= left && nums[j] == target) {
                    j--;
                }

                return new int[]{j + 1, i - 1};
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    // 167 两数之和
    // 方法一 双指针
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }

            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }

    // 方法二  二分法
    public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;

        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left <= right) {
                int mid = left + (right - left + 1) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                }

                if (numbers[mid] > target - numbers[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }

    // 153. 寻找旋转排序数组中的最小值
    // 方法一 排序
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    // 方法二 双指针
    public int findMin2(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            left++;
        }

        return nums[left];
    }

    // 方法二 双指针
    public int findMin3(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                right--;
            } else {
                left++;
            }
        }

        return nums[left];
    }

    // 方法二 二分法
    public int findMin4(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left];
    }


    // 154. 寻找旋转排序数组中的最小值 II
    // 方法一 排序
    public int findMin21(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    // 方法二 双指针
    public int findMin22(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            if (nums[left] == nums[right] && (left + 1 <= right) && nums[left] < nums[left + 1] && (right - 1 >= left) && nums[right] < nums[right - 1]) {
                return nums[left];
            }

            left++;
        }

        return nums[left];
    }

    // 方法三 二分法
    public int findMin23(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                right--;
            }
        }

        return nums[left];
    }

    // 33. 搜索旋转排序数组
    // 方法一 双指针
    public int search21(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            if (nums[left] > target) {
                left++;
            } else {
                right--;
            }
        }

        return -1;
    }

    // 方法二 二分法
    public int search22(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[0]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // 81 搜索旋转排序数组 II
    // 方法一 双指针
    public boolean search41(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (nums[left] == target) {
                return true;
            }

            if (nums[right] == target) {
                return true;
            }

            if (nums[left] > target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    // 方法二 二分
    public boolean search42(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    // 278 第一个错误的版本
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while(left <= right) {
            int mid = left + (right - left + 1) /2;
            if(isBadVersion(mid)) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return left;
    }

    // 162 寻找峰值
    // 方法一 找最大值
    public int findPeakElement(int[] nums) {
        int len = nums.length;

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }

        return index;
    }

    // 方法二 二分爬坡法
    public int findPeakElement2(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right =
                len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 852、山脉数组的峰顶索引
    // 方法一 找最大值
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;

        int max = 0;
        for (int i = 0; i < len; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }

        return max;
    }

    // 方法二 双指针
    public int peakIndexInMountainArray2(int[] arr) {
        int len = arr.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return left;
    }

    // 方法三 二分爬坡法
    public int peakIndexInMountainArray3(int[] arr) {
        int len = arr.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 1095. 山脉数组中查找目标值
    // 方法一 双指针，但是调用超过100次
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && mountainArr.get(left) != target) {
                left++;
            }

            while (right > left && mountainArr.get(right) != target) {
                right--;
            }

            if (mountainArr.get(left) == target) {
                return left;
            } else if (mountainArr.get(right) == target) {
                return right;
            }


        }

        return -1;
    }

    // 方法二
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int maxIndex = findMaxIndex(len, mountainArr);
        if (mountainArr.get(maxIndex) == target) {
            return maxIndex;
        }

        int leftIndex = findLeftTargetIndex(mountainArr, 0, maxIndex - 1, target);
        if (leftIndex != -1) {
            return leftIndex;
        }

        int rightIndex = findRightTargetIndex(mountainArr, maxIndex + 1, len - 1, target);
        if (rightIndex != -1) {
            return rightIndex;
        }

        return -1;
    }

    // 爬坡发，找最大值
    private int findMaxIndex(int len, MountainArray mountainArr) {
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 在升序中找target
    private int findLeftTargetIndex(MountainArray mountainArr, int begin, int end, int target) {
        int left = begin;
        int right = end;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }

            if (mountainArr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // 在逆序中找target
    private int findRightTargetIndex(MountainArray mountainArr, int begin, int end, int target) {
        int left = begin;
        int right = end;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }

            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // 744. 寻找比目标字母大的最小字母
    // 方法一 暴力解法
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;

        for (int i = 0; i < len; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }

        return letters[0];
    }

    // 方法二 二分法-- 与爬坡思路类似，这是一直下坡
    public char nextGreatestLetter2(char[] letters, char target) {
        int len = letters.length;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (letters[left] <= target) {
            return letters[0];
        } else {
            return letters[left];
        }
    }

    // 4. 寻找两个正序数组的中位数
    // 方法一 双指针 合并数组
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] arr = new int[len1 + len2];
        int i = 0;
        int j = 0;

        int index = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                arr[index++] = nums1[i++];
            } else {
                arr[index++] = nums2[j++];
            }
        }

        while (i < len1) {
            arr[index++] = nums1[i++];
        }
        while (j < len2) {
            arr[index++] = nums2[j++];
        }

        if (arr.length % 2 == 0) {
            return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else {
            return (double) arr[arr.length / 2];
        }
    }

    // 方法二 二分法
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        }
    }

    // 74 搜索二维矩阵
    // 方法一 暴力解法
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;

        for (int i = 0; i < row; i++) {
            int cols = matrix[i].length;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // 方法二 二分法
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;

        int left = 0;
        int right = row - 1;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            int cols = matrix[mid].length;

            if (matrix[mid][0] == target || matrix[mid][cols - 1] == target) {
                return true;
            }

            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][cols - 1] < target) {
                left = mid + 1;
            } else {
                return findTarget(matrix[mid], target);
            }
        }

        return false;
    }

    public boolean findTarget(int[] arr, int target) {
        int len = arr.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return arr[left] == target;
    }

    // 方法三 一次二分法
    public boolean searchMatrix3(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            int x = matrix[mid / col][mid % col];
            if (x == target) {
                return true;
            }

            if (x > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    // 240. 搜索二维矩阵 II
    // 方法一 每行二分查找
    public boolean searchMatrix21(int[][] matrix, int target) {
        int row = matrix.length;

        for (int i = 0; i < row; i++) {
            int cols = matrix[i].length;

            int left = 0;
            int right = cols - 1;
            while (left <= right) {
                int mid = left + (right - left + 1) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                }

                if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    // 方法二 每行二分查找并跳过不满足的行
    public boolean searchMatrix22(int[][] matrix, int target) {
        int row = matrix.length;

        for (int i = 0; i < row; i++) {
            int cols = matrix[i].length;

            if (matrix[i][cols - 1] < target) {
                continue;
            }
            int left = 0;
            int right = cols - 1;
            while (left <= right) {
                int mid = left + (right - left + 1) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                }

                if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    // 方法二 一起二分查找
    public boolean searchMatrix23(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}

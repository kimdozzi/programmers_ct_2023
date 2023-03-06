package com.ll.LeetCode.easy.p35;

public class Main {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while(left <= right) {
                int mid = (left+right)/2;
                if(nums[mid] == target) {
                    return mid;
                }
                else if(nums[mid] <= target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        new Solution().searchInsert(arr, 2);
    }
}

package com.ll.LeetCode.easy.p1;

public class Main {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] arr = new int[2];
            boolean flag = false;
            for(int i = 0; i < nums.length; i++) {
                if (flag) break;
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[i] + nums[j] == target) {
                        arr[0] = i;
                        arr[1] = j;
                        flag = true;
                        break;
                    }
                }
            }
            return arr;
        }
    }
}

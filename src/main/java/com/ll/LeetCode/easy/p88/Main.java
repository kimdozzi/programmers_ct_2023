package com.ll.LeetCode.easy.p88;

public class Main {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int A = m - 1;
            int B = n - 1;
            int C = m + n - 1;
            while (A >= 0 && B >= 0)
                nums1[C--] = (nums1[A] > nums2[B]) ? nums1[A--] : nums2[B--];

            while(B>=0)
                nums1[C--] = nums2[B--];
        }
    }
}

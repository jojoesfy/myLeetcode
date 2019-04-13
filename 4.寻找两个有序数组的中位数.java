
/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (34.39%)
 * Total Accepted:    47.7K
 * Total Submissions: 138.6K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int lengthAll = len1 + len2;

        int inx1 = 0;
        int inx2 = 0;
        int x = -1;
        int y = -1;
        while (inx1 + inx2 < lengthAll) {
            if (inx1 < len1) {
                while (inx2 == len2 || nums1[inx1] <= nums2[inx2]) {
                    inx1++;
                    if (inx1 + inx2 == (lengthAll + 1) / 2) {
                        x = nums1[inx1 - 1];
                    }
                    if (inx1 + inx2 == (lengthAll + 2) / 2) {
                        y = nums1[inx1 - 1];
                        return (x + y) * 1.0 / 2;
                    }
                    if (inx1 == len1) {
                        break;
                    }
                }
            }
            if (inx2 < len2) {
                while (inx1 == len1 || nums2[inx2] <= nums1[inx1]) {
                    inx2++;
                    if (inx1 + inx2 == (lengthAll + 1) / 2) {
                        x = nums2[inx2 - 1];
                    }
                    if (inx1 + inx2 == (lengthAll + 2) / 2) {
                        y = nums2[inx2 - 1];
                        return (x + y) * 1.0 / 2;
                    }
                    if (inx2 == len2) {
                        break;
                    }

                }
            }

        }

        return -1;

    }
}


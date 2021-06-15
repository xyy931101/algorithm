package algorithm.leetcode.array;

import jdk.nashorn.internal.ir.ReturnNode;

/**
 * 852. 山脉数组的峰顶索引
 * @author: xiongyayun
 * @date: 2021/6/15 9:28 下午
 */
public class PeakIndexInAMountainArray852 {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid - 1] < arr[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}

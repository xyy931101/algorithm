package algorithm.leetcode.binary;

/**
 * @author: xiongyayun
 * @date: 2021/7/12 8:24
 */
public class HIndexII275 {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0,1,3,5,6}));
    }


    public static int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

}

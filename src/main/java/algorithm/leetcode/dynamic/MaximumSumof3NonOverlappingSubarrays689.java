package algorithm.leetcode.dynamic;

/**
 * 689. 三个无重叠子数组的最大和
 * @author: xiongyayun
 * @date: 2021/9/6 11:21 下午
 */
public class MaximumSumof3NonOverlappingSubarrays689 {

    public static void main(String[] args) {
        System.out.println(maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2));
        System.out.println(maxSumOfThreeSubarrays2(new int[]{1,2,1,2,1,2,1,2,1,2}, 2));
    }


    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int N = nums.length;
        int[] range = new int[N];//必须下标i作为结尾的K长度的值
        int[] left = new int[N]; //记录从左往右,的长度为K的最大的值得下标
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        range[0] = sum;  //记录第一个以0位头的,长度为K的子数组的值
        left[k - 1] = 0; //第一个最大值
        int max = sum;
        //因为第一个已经算了,所以以k为起点, 又因为又右数组，所以先只要算到N-K
        for (int i = k; i < N; i++) {
            sum = sum + nums[i] - nums[i - k];
            range[i - k + 1] = sum;
            left[i] = left[i - 1];
            if (sum > max) {
                max = sum;
                left[i] = i - k + 1;
            }
        }

        sum = 0;
        for (int i = N - 1; i >= N - k; i--) {
            sum += nums[i];
        }
        max = sum;
        int[] right = new int[N];
        right[N - k] = N - k;
        for (int i = N - k - 1; i >= 0; i--) {
            sum = sum - nums[i + k] + nums[i];
            //默认最大的是右边的
            right[i] = right[i + 1];
            //当出现比前面大的子数组时,记录right位置
            if (sum >= max) {
                max = sum;
                right[i] = i;
            }
        }
        int a = 0, b = 0, c = 0;
        max = 0;
        for (int i = k; i < N - k; i++){
            int part1 = range[left[i - 1]];
            int part2 = range[i];
            int part3 = range[right[i + k]];
            if (part1 + part2 + part3 > max) {
                max = part1 + part2 + part3;
                a = left[i - 1];
                b = i;
                c = right[i + k];
            }
        }
        return new int[] {a, b, c};
    }

    //个人认为这个比较好
    public static int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
        int len = nums.length;
        int n = len - k + 1;
        //计算每个子数组的和
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum = sum + nums[i];
            if (i >= k) {
                sum = sum - nums[i - k];
            }
            if (i >= k - 1) {
                dp[i - k + 1] = sum;
            }
        }

        //left right分别是左右最大的子数组的位置
        int[] left = new int[n];
        int[] right = new int[n];

        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > dp[maxIndex]){
                maxIndex = i;
            }
            left[i] = maxIndex;
        }
        maxIndex = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (dp[i] >= dp[maxIndex]) {
                maxIndex = i;
            }
            right[i] = maxIndex;
        }

        int[] res = new int[3];
        //滑动中间的一个子数组,分别向左边和右边获取最大的子数组
        for (int i = k; i < n - k; i++) {
            if (res[2] == 0 ||
                    dp[res[0]] + dp[res[1]] + dp[res[2]] < dp[left[i - k]] + dp[i] + dp[right[i + k]]){
                res[0] = left[i - k];
                res[1] = i;
                res[2] = right[i + k];
            }
        }
        return res;
    }

}

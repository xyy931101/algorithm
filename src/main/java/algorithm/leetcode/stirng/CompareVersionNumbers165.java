package algorithm.leetcode.stirng;

/**
 * 165. 比较版本号
 * @author: xiongyayun
 * @date: 2022/3/2 11:00 下午
 */
public class CompareVersionNumbers165 {


    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int m = v1.length, n = v2.length;
        int i = 0, j = 0;
        while(i < m || j < n){
            int num1 = 0, num2 = 0;
            while(i < m && v1[i] != '.'){
                num1 = num1 * 10 + v1[i++] - '0';
            }
            while(j < n && v2[j] != '.'){
                num2 = num2 * 10 + v2[j++] - '0';
            }
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }else{
                i++;
                j++;
            }
        }
        return 0;
    }

}

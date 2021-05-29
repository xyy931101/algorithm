package algorithm;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/2 20:41
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class Xor {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int [] arr = new int[]{1,2,4,3,3,2,2,3,4,2,3, 1,6};

        int result = 0;
        for (int i : arr) {
            result = result ^ i;
        }
        System.out.println(result);

        System.out.println(getRightOne(32));
    }

    private static int getRightOne(int num){
//        Stack
        int temp = ~num + 1;
        return num & temp;
    }



}

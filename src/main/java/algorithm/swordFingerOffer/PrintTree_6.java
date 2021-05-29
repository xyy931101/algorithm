package algorithm.swordFingerOffer;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer第六题
 * 从尾到头打印数组
 * @Author: Xiongyy
 * @Date: 2021/2/8 23:11
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class PrintTree_6 {

    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        printListReverse(head);
        List<Integer> nums = new ArrayList<>();
        addListReverse(head, nums);
        System.out.println(JSONObject.toJSONString(nums.toArray()));
    }

    private static void printListReverse(ListNode head){
        if(head.next != null){
            printListReverse(head.next);
        }
        System.out.println(head.value);
    }

    private static void addListReverse(ListNode head, List<Integer> nums){
        if(head.next != null){
            addListReverse(head.next, nums);
        }
        nums.add(head.value);
    }
}

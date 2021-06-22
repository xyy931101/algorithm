package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Xiongyy
 * @Date: 2021/3/29 8:25
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class Permute_46 {

    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public static void main(String[] args) {
        Permute_46 p = new Permute_46();
        List<List<Integer>> permute = p.permute(new int[]{1, 2, 3});

        System.out.println(JSONObject.toJSONString(permute));
    }

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return res;
        }
        this.nums = nums;
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(path, used);

        return res;
    }

    private void dfs(LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length)  res.add(new LinkedList<>(path));
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            path.addLast(nums[i]);
            used[i] = true;
            dfs(path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}

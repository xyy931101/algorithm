package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2022/1/13 9:31 下午
 */
public class PermutationsII47 {


    public static void main(String[] args) {
        PermutationsII47 p = new PermutationsII47();
        System.out.println(JSONObject.toJSONString(p.permuteUnique(new int[]{1,1,2})));

    }


    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> path = new ArrayList();
        dfs(path, used);
        return res;
    }

    public void dfs(List<Integer> path, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(path, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

}

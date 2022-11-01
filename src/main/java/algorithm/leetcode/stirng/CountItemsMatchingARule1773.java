package algorithm.leetcode.stirng;

import java.util.List;

/**
 * 773. 统计匹配检索规则的物品数量
 * @author: xiongyayun
 * @date: 2022/10/29 11:37
 */
public class CountItemsMatchingARule1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        switch (ruleKey){
            case "type":
                return countMatches(items, 0, ruleValue);
            case "color":
                return countMatches(items, 1, ruleValue);
            case "name":
                return countMatches(items, 2, ruleValue);
        }
        return 0;
    }


    public int countMatches(List<List<String>> items, int index, String ruleValue) {
        int res = 0;
        for(List<String> item : items){
            if(ruleValue.equals(item.get(index))) res++;
        }
        return res;
    }

}

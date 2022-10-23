package algorithm.leetcode.stirng;

import java.util.*;

/**
 * 811. 子域名访问计数
 * @author: xiongyayun
 * @date: 2022/10/5 18:18
 */
public class SubdomainVisitCount811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null || cpdomains.length == 0) return Collections.emptyList();
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for(String str : cpdomains){
            int n = str.length(), idx = 0;
            while (idx < n && str.charAt(idx) != ' ') idx++;
            int cnt = Integer.parseInt(str.substring(0, idx));
            int start = idx + 1; idx = n - 1;
            while (idx >= start) {
                while (idx >= start && str.charAt(idx) != '.') idx--;
                String cur = str.substring(idx + 1);
                countMap.put(cur, countMap.getOrDefault(cur, 0) + cnt);
                idx--;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key : countMap.keySet()) ans.add(countMap.get(key) + " " + key);
        return ans;
    }
}

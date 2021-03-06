package algorithm.leetcode.stirng;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * @author: xiongyayun
 * @date: 2021/11/28 21:36
 */
public class FindAllAnagramsInAString438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int a = 0;
        for (int i = 0; i < 26; i++) if (count[i] != 0) a++;

        for (int l = 0, r = 0, b = 0; r < s.length(); r++) {
            if (--count[s.charAt(r) - 'a'] == 0) b++;
            if (r - l + 1 > p.length() && ++count[s.charAt(l++) - 'a'] == 1) b--;
            if (a == b) ans.add(l);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(findAnagrams2("cbaebabacd","abc")));
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        if(p.length() > s.length()){
            return Collections.emptyList();
        }
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();
        int[] count = new int[26];
        for(char c : str2){
            count[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        //p中有多少个字符
        int a = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                a++;
            }
        }
        int left=0, right = 0, b = 0;
        while(right < str1.length){
            if(--count[str1[right] - 'a'] == 0){
                b++;
            }
            //由0变为1
            if(right - left + 1 > str2.length && ++count[str1[left++] - 'a'] == 1){
                b--;
            }
            if(a == b){
                ans.add(left);
            }
            right++;
        }
        return ans;
    }
}

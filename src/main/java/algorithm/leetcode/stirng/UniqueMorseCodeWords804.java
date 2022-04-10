package algorithm.leetcode.stirng;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 * @author: xiongyayun
 * @date: 2022/4/10 13:48
 */
public class UniqueMorseCodeWords804 {


    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        Set<String> set = new HashSet<String>();

        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                sb.append(morse[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

}

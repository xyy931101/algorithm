package algorithm.leetcode.linkedList;

import lombok.Data;

import java.util.List;

/**
 * @Author: Xiongyy
 * @Date: 2021/5/1 23:05
 * .............................................
 * 佛祖保佑             永无BUG
 */
@Data
public class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;
}

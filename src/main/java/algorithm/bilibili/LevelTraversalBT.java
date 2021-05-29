package algorithm.bilibili;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树，层级优先遍历
 * @Author: Xiongyy
 * @Date: 2021/2/6 15:32
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LevelTraversalBT {

    public static void main(String[] args) {
        Node head = Node.getHead();
        //按照层级遍历打印
        level(head);
        System.out.println();
        //打印出二叉树的最大的层级的节点数
        System.out.println(maxWithMap(head));
        System.out.println(maxWithNoMap(head));
    }

    public static void level(Node head){
        if (head == null){
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.value + ", ");
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }

        }
    }

    /**
     * 利用HashMap获取最大的层级宽度
     * @param head
     * @return
     */
    public static int maxWithMap(Node head){
        if (head != null){
            //记录每个节点在那个层级
            HashMap<Node, Integer> levelMap = new HashMap<>(16);
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            levelMap.put(head, 1);
            int max = 0;
            int currentLevel = 1;
            int currentNodes = 0;
            while(!queue.isEmpty()){
                Node cur = queue.poll();
                //当前节点所在的层级
                Integer curNodeLevel = levelMap.get(cur);
                if (cur.left != null){
                    queue.add(cur.left);
                    levelMap.put(cur.left, currentLevel + 1);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    levelMap.put(cur.right, currentLevel + 1);
                }

                if(currentLevel == curNodeLevel){
                    currentNodes++;
                }else{
                    max = Math.max(max, currentNodes);
                    currentNodes = 1;
                    currentLevel++;
                }
            }
            max = Math.max(max, currentNodes);
            return max;
        }
        return 0;
    }


    /**
     * 不利用map获取最大层级宽度
     * @param head
     * @return
     */
    public static int maxWithNoMap(Node head){
        if (head != null){
            //记录每个节点在那个层级

            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            Node nextEnd = head;
            Node curEnd = head;
            int max = 0;
            int currentNodes = 0;
            while(!queue.isEmpty()){
                Node cur = queue.poll();
                //当前节点所在的层级
                if (cur.left != null){
                    queue.add(cur.left);
                    nextEnd = cur.left;
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    nextEnd = cur.right;
                }

                if(cur != curEnd){
                    currentNodes++;
                }else{
                    max = Math.max(max, currentNodes);
                    currentNodes = 1;
                    curEnd = nextEnd;
                }
            }
            return max;
        }
        return 0;
    }
}

package algorithm.leetcode.unionFind;

/**
 * @author: xiongyayun
 * @date: 2021/7/31 17:07
 * [[1,0,0,1],   0
 *  [0,1,1,0],   1
 *  [0,1,1,1],   2
 *  [1,0,1,1]]   3
 */
public class NumberOfProvinces547 {

    public static void main(String[] args) {
        NumberOfProvinces547 n = new NumberOfProvinces547();
        System.out.println(n.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        UnionFind unionFind = new UnionFind(length);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets;
    }

    public static class UnionFind {

        // parent[i] = k ： i的父亲是k
        private int[] parent;
        // size[i] = k ： 如果i是代表节点，size[i]才有意义，否则无意义
        // i所在的集合大小是多少
        private int[] size;
        // 辅助结构
        private int[] help;
        // 一共有多少个集合
        private int sets;


        public UnionFind(int N) {
            parent = new int[N];
            size = new int[N];
            help = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findFarther(int i){
            int count = -1;
            while (parent[i] != i) {
                help[++count] = i;
                i = parent[i];
            }

            for (int j = count; j >= 0; j--) {
                parent[help[j]] = i;
            }
            return i;
        }

        public void union(int i, int j) {
            int fartherI = findFarther(i);
            int fartherJ = findFarther(j);
            if (fartherI != fartherJ) {
                if (size[fartherI] >= size[fartherJ]) {
                    parent[fartherJ] = fartherI;
                    size[fartherI] = size[fartherI] + size[fartherJ];
                }else {
                    parent[fartherI] = fartherJ;
                    size[fartherJ] = size[fartherJ] +size[fartherI];
                }
                sets--;
            }
        }
    }
}

package algorithm.bilibili;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/7 20:29
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class PaperFolding {

    public static void main(String[] args) {
        printAllFolds(4);
    }

    public static void printAllFolds(int n){
        printProcess(1, n, true);
    }

    private static void printProcess(int i, int n, boolean down) {
        if(i > n){
            return;
        }
        printProcess(i + 1, n, true);
        System.out.print(down? "凹" : "凸");

        printProcess(i + 1, n, false);
    }
}

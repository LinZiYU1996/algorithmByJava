package sword_offer_01;

import java.util.LinkedList;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 *
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 *
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, null, 4, null, null, null]
 *     8
 *    / \
 *   12  2
 *      /
 *     6
 *    /
 *   4
 *
 * 输出：[[8], [12, 2], [6], [4]]
 *
 *
 * @Date: Create in 20:20 2019/4/27
 */
public class PrintFromTopToBottom_P {

//    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
//
//    }


    public void printTree2(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        int pCount = 0;      //当前层结点数目
        int nextCount = 1;   //下一层结点数目
        while (!queue.isEmpty()) {
            pCount = nextCount;
            nextCount = 0;
            //打印当前层数字，并计算下一层结点数目
            for (int i = 1; i <= pCount; i++) {
                node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            System.out.println();
        }
    }




}

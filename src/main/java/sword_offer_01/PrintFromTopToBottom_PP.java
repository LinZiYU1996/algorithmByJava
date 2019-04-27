package sword_offer_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 请实现一个函数按照之字形顺序从上向下打印二叉树。
 *
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 * 输出：[[8], [2, 12], [6, 4]]
 *
 *
 *
 * @Date: Create in 20:35 2019/4/27
 */
public class PrintFromTopToBottom_PP {

    //一个队列只能从一个方向按顺序进入队列，没有办法做到两个方向的之字打印。
    //
    //用两个栈，每个分别记录一层，第一层用stack1,第二层用stack2，交替使用，如果当前的栈不为空，则一直循环弹栈，然后将其左右子树压入另一个栈，直到栈为空。



    public List<List<Integer>> printFromTopToBottom(TreeNode root) {

        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        if(root==null)
            return arr;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);

        while(!stack1.empty()||!stack2.empty()){
            if(!stack1.empty()){
                ArrayList<Integer> arr1 = new ArrayList<Integer>();
                while(!stack1.empty()){
                    TreeNode node = stack1.pop();
                    arr1.add(node.val);
                    if(node.left!=null)
                        stack2.push(node.left);
                    if(node.right!=null)
                        stack2.push(node.right);
                }
                arr.add(arr1);
            }
            else{
                ArrayList<Integer> arr1 = new ArrayList<Integer>();
                while(!stack2.empty()){
                    TreeNode node = stack2.pop();
                    arr1.add(node.val);
                    if(node.right!=null)
                        stack1.push(node.right);
                    if(node.left!=null)
                        stack1.push(node.left);
                }
                arr.add(arr1);
            }
        }
        return arr;


    }



}

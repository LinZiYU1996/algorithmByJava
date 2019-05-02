package sword_offer_02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 您需要确保二叉树可以序列化为字符串，并且可以将此字符串反序列化为原始树结构。
 *
 * 样例
 * 你可以序列化如下的二叉树
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 *
 * 为："[8, 12, 2, null, null, 6, 4, null, null, null, null]"
 * 注意:
 *
 * 以上的格式是AcWing序列化二叉树的方式，你不必一定按照此格式，所以可以设计出一些新的构造方式。
 *
 *
 * @Date: Create in 21:32 2019/5/2
 */
public class serializeAnddeserialize {

    //(序列化，队列) O(n)O(n)
    //序列化主要是对二叉树的广度优先遍历，可以每序列化一个节点，就把他的节点按照先左后右的顺序压入队列，然后从队列前面取出，再将其子树的左右子树压入队列。空为#，各个节点之间用！来分开
    //
    //反序列化将序列化的字符串按！分割即可。然后放进队列，重建即可。



    // Encodes a tree to a single string.
    String serialize(TreeNode root) {

        if(root==null)
            return "#!";

        String res = root.val+"!";
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.left!=null){
                res+=root.left.val+"!";
                q.offer(root.left);
            }else{
                res+="#!";
            }

            if(root.right!=null){
                res+=root.right.val+"!";
                q.offer(root.right);
            }else{
                res+="#!";
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        String[] values = data.split("!");
        int index = 0;
        TreeNode root = generateNodeByString(values[index++]);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root != null){
            q.offer(root);
        }

        TreeNode node = null;
        while(!q.isEmpty()){
            node = q.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode generateNodeByString(String val){
        if(val.equals("#"))
            return null;

        return new TreeNode(Integer.valueOf(val));
    }


}

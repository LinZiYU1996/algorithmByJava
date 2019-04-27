package sword_offer_01;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *
 * 如果是则返回true，否则返回false。
 *
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 样例
 * 输入：[4, 8, 6, 12, 16, 14, 10]
 *
 * 输出：true
 *
 *
 *
 * @Date: Create in 20:38 2019/4/27
 */
public class VerifySequenceOfBST_P {

    //二叉树后序遍历数组的最后一个数为根结点，剩余数字中，小于根结点的数字
    // （即左子树部分）都排在前面，大于根结点的数字（即右子树部分）都排在后面。根据遍历数组的这个特性，可以编写出一个递归函数，用于实现题目所要求的判断功能。



//    public boolean verifySequenceOfBST(int [] sequence) {
//
//    }

    public boolean  verifySquenceOfBST(int[] sequence) {
        if(sequence== null || sequence.length<=0)
            return false;
        return verifyCore(sequence, 0, sequence.length-1);
    }

    private boolean verifyCore(int[] sequence,int start,int end) {
        if(start>=end)
            return true;
        //判断左子树
        int mid=start;
        while(sequence[mid]<sequence[end])
            mid++;
        //判断右子树
        for(int i=mid;i<end;i++) {
            if(sequence[i]<sequence[end])
                return false;
        }
        return verifyCore(sequence, start, mid-1)&&verifyCore(sequence, mid, end-1);
    }


}

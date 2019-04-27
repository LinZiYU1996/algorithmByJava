package sword_offer_01;

import java.util.Stack;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *
 * 假设压入栈的所有数字均不相等。
 *
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *
 * 注意：若两个序列长度不等则视为并不是一个栈的压入、弹出序列。若两个序列都为空，则视为是一个栈的压入、弹出序列。
 *
 * 样例
 * 输入：[1,2,3,4,5]
 *       [4,5,3,2,1]
 *
 * 输出：true
 *
 *
 * @Date: Create in 20:11 2019/4/27
 */
public class IsPopOrder_P {

    //建立一个栈，按照压栈序列依次进行入栈操作，按出栈序列的顺序依次弹出数字。
    // 在出栈时，若下一个要出栈的数字与栈顶数字相同则弹出。如果压栈序列中的所有数字都入栈后没有完全出栈成功则代表两个序列不匹配，返回false。




    public boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA==null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        //必须提前判断长度是否相等
        if(popA.length!=pushA.length || pushA.length==0)
            return false;
        int popIndex=0;
        for(int pushIndex=0; pushIndex<pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while(!stack.empty() &&stack.peek()==popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();



    }



}

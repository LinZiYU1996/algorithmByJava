package sword_offer_01;

import java.util.Stack;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 设计一个支持push，pop，top等操作并且可以在O(1)时间内检索出最小元素的堆栈。
 *
 * push(x)–将元素x插入栈中
 * pop()–移除栈顶元素
 * top()–得到栈顶元素
 * getMin()–得到栈中最小元素
 * 样例
 * MinStack minStack = new MinStack();
 * minStack.push(-1);
 * minStack.push(3);
 * minStack.push(-4);
 * minStack.getMin();   --> Returns -4.
 * minStack.pop();
 * minStack.top();      --> Returns 3.
 * minStack.getMin();   --> Returns -1.
 *
 *
 *
 * @Date: Create in 20:00 2019/4/27
 */
public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.empty()){
            min.push(x);
        }else{
            Integer minNum = min.peek();
            if(x<=minNum){
                min.push(x);
            }else{
                min.push(minNum);
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }





}

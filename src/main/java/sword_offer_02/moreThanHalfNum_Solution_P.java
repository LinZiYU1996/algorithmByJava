package sword_offer_02;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 假设数组非空，并且一定存在满足条件的数字。
 *
 * 思考题：
 *
 * 假设要求只能使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？
 * 样例
 * 输入：[1,2,1,1,3]
 *
 * 输出：1
 *
 *
 * @Date: Create in 21:45 2019/5/2
 */
public class moreThanHalfNum_Solution_P {

    public int moreThanHalfNum_Solution(int[] nums) {

        if(nums==null||nums.length==0)
            return 0;

        int halfNum = nums[0];
        int sum = 1;
        for(int i = 1;i<nums.length;i++){
            if(halfNum==nums[i])
                sum++;
            else{
                if(sum==1){
                    halfNum=nums[i];
                }else{
                    sum--;
                }
            }
        }

        return halfNum;

    }
}

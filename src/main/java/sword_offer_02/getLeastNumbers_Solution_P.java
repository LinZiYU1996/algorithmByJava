package sword_offer_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 输入n个整数，找出其中最小的k个数。
 *
 * 注意：
 *
 * 数据保证k一定小于等于输入数组的长度;
 * 输出数组内元素请按从小到大顺序排序;
 * 样例
 * 输入：[1,2,3,4,5,6,7,8] , k=4
 *
 * 输出：[1,2,3,4]
 *
 *
 * @Date: Create in 21:49 2019/5/2
 */
public class getLeastNumbers_Solution_P {


    //ACM
    public List<Integer> getLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length == 0 ){
            return res;
        }

        Arrays.sort(input);

        for (int i = 0; i < k ; i++) {
            res.add(input[i]);
        }
        return res;

    }


}

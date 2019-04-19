package sword_offer;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 给你一根长度为 n 绳子，请把绳子剪成 m 段（m、n 都是整数，2≤n≤58 并且 m≥2）。

每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]k[1] … k[m] 可能的最大乘积是多少？

例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。

样例
输入：8

输出：18
 * @Date 20:02 2019/4/19
 **/
public class TestmaxProductAfterCutting {

    //本题采用动态规划或者贪婪算法可以实现。一开始没有思路时，可以从简单的情况开始想，试着算以下比较短的绳子是如何剪的。
    //
    //　　当n=1时，最大乘积只能为0；
    //
    //　　当n=2时，最大乘积只能为1；
    //
    //　　当n=3时，最大乘积只能为2；
    //
    //　　当n=4时，可以分为如下几种情况:1*1*1*1，1*2*1，1*3，2*2，最大乘积为4；
    //
    //　　往下推时，发现n≥4时，可以把问题变成几个小问题，即：如果把长度n绳子的最大乘积记为f(n)，
    // 则有：f(n)=max(f(i)*f(n-1))，0<i<n。所以思路就很容易出来了：
    // 从下往上推，先算小的问题，再算大的问题，大的问题通过寻找小问题的最优组合得到。
    //
    //　　其实这就是动态规划法，以下是动态规划法的几个特点：
    //
    //　　1.求一个问题的最优解
    //
    //　　2.整体问题的最优解依赖各子问题的最优解
    //
    //　　3.小问题之间还有相互重叠的更小的子问题
    //
    //　　4.为了避免小问题的重复求解，采用从上往下分析和从下往上求解的方法求解问题



    public int maxProductAfterCutting(int length)
    {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] product = new int[length + 1]; // 用于存放最大乘积值
        // 下面几个不是乘积，因为其本身长度比乘积大
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        // 开始从下到上计算长度为i绳子的最大乘积值product[i]
        for (int i = 4; i <= length; i++) {
            int max = 0;
            // 算不同子长度的乘积，找出最大的乘积
            for (int j = 1; j <= i / 2; j++) {
                if (max < product[j] * product[i - j])
                    max = product[j] * product[i - j];
            }
            product[i] = max;
        }
        return product[length];
    }


    // =======贪婪算法========
    public int maxProductAfterCutting_solution2(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length / 3;
        int timesOf2 = 0;
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
            // timesOf2=2;  //错误！
        }
        timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {

    }

}

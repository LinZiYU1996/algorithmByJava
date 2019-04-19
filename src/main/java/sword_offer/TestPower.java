package sword_offer;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 *实现函数double Power(double base, int exponent)，求base的 exponent次方。

不得使用库函数，同时不需要考虑大数问题。

注意：

不会出现底数和指数同为0的情况
样例1
输入：10 ，2

输出：100
样例2
输入：10 ，-2

输出：0.01
 *
 * @Date 20:44 2019/4/19
 **/
public class TestPower {

   //道题很容易实现，但需要注意以下陷阱：1）0的负数次方不存在；2）
    // 0的0次方没有数学意义；3）要考虑exponent为负数的情况。
    // 所以可以对exponent进行分类讨论，在对base是否为0进行讨论。



    public double power(double base, int exponent) {
        if (exponent == 0) return 1;
        double res = 1;
        int  k = 0;
        if (exponent < 0){
            k = exponent*(-1);
        }
        else{
            k = exponent;
        }
        for(int i = 0; i < k; i++){
            res = res * base;
        }
        if (exponent < 0){
            return 1.0/res;
        }
        return res;
    }



    public static void main(String[] args) {
//        System.out.println(Power(100,2));
    }
}

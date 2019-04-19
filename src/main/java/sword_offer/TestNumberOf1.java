package sword_offer;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *输入一个32位整数，输出该数二进制表示中1的个数。

注意：

负数在计算机中用其绝对值的补码来表示。
样例1
输入：9
输出：2
解释：9的二进制表示是1001，一共有2个1。
样例2
输入：-2
输出：31
解释：-2在计算机里会被表示成11111111111111111111111111111110，
      一共有31个1。
 *
 * @Date 20:28 2019/4/19
 **/
public class TestNumberOf1 {



    //AC
    //基于JDK的API
    public static int NumberOf1(int n)
    {
        String num = Integer.toBinaryString(n);
        int index = 0;
        for (int i = 0; i < num.length() ; i++) {
            if (num.charAt(i) == '1') {
                index++;
            }
        }
        return index;
    }



    //遇到与二进制有关的题目，应该想到位运算(与、或、异或、左移、右移)。
    //
    //　　方法一：”与运算“有一个性质：通过与对应位上为1，其余位为0的数进行与运算，
    // 可以某一整数指定位上的值。这道题中，先把整数n与1做与运算，判断最低位是否为1；
    // 接着把1左移一位，与n做与运算，可以判断次低位是否为1……反复左移，即可对每一个位置都进行判断，
    // 从而可以获得1的个数。这种方法需要循环判断32次。
    //
    //　　方法二（better）：如果一个整数不为0，把这个整数减1，
    // 那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1。
    // 其余所有位将不会受到影响。再把原来的整数和减去1之后的结果做与运算，
    // 从原来整数最右边一个1那一位开始所有位都会变成0。因此，把一个整数减1
    // ，再和原来的整数做与运算，会把该整数最右边的1变成0。这种方法
    // ，整数中有几个1，就只需要循环判断几次。

    public int NumberOf1_Solution1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public int NumberOf1_Solution2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-2));
    }
}

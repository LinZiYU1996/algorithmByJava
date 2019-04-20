package sword_offer;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *题目
　　输入数字n，按顺序打印出从1最大的n位十进制数。
* 比如输入3，则打印出1、2、3一直到最大的3位数即999。
 * @Date 21:04 2019/4/19
 **/
public class Testprint1ToMaxOfNDights1s {

    //思路
    //　　陷阱：n过大时是大数问题，不能简单用int或者long数据输出，需要采用字符串或者数组表达大数。
    //
    //　　解决方法：通过字符数组char[]来进行输出数字。
    //
    //　方法一：
    //
    //　　1）在字符串表达的数字上模拟加法；
    //
    //　　2）把字符串表达的数字打印出来。
    //
    //　方法二：
    //
    //　　1）采用递归将每一位都从0到9排列出来；
    //
    //　　2）把字符串表达的数字打印出来。




    /**
     * 打印字符数组形成的数字
     * 自己的方法：找出第一个非零字符位置，往后进行打印
     */
    private void printCharNumber2(char[] number) {
        int beginner = number.length; // 不写成number.length-1，以防写出0
        for (int i = 0; i <= number.length - 1; i++) {
            if ((number[i] - '0') != 0) {
                beginner = i;
                break;
            }
        }
        for (int i = beginner; i <= number.length - 1; i++) {
            System.out.print(number[i]);
        }
        if (beginner != number.length) // 数字为0时，换行符不输出
            System.out.println();
    }


    //=========方法二============
    /**
     * 采用递归的方法
     */
    public void print1ToMaxOfNDigits2(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        for (int k = 0; k < number.length; k++)
            number[k] = '0';
        for (int i = 0; i <= 9; i++) {
            makeNumber(n, number, i, 0);
        }
    }

    /**
     * 生成数字
     */
    private void makeNumber(int n, char[] number, int nNumber, int index) {
        if (index == number.length - 1) {
            number[index] = (char) (nNumber + '0');
            printCharNumber2(number); // 打印数字代码与第一个方法一样
            return;
        } else {
            number[index] = (char) (nNumber + '0');
            for (int i = 0; i <= 9; i++) {
                makeNumber(n, number, i, index + 1);
            }
        }
    }
}

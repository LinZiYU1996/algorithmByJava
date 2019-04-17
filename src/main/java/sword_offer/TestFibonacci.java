package sword_offer;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *输入一个整数 n ，求斐波那契数列的第 n 项。

假定从0开始，第0项为0。(n<=39)

样例
输入整数 n=5

返回 5
*
*
* f(n) = 1:0 n=0
*        2:1 n=1
*       3: f(n-1)+f(n-2)  n > 1
 *
 *
 *
 *
 * 思路
　　如果直接写递归函数，由于会出现很多重复计算，效率非常底，不采用。

　　要避免重复计算，采用从下往上计算，可以把计算过了的保存起来
* ，下次要计算时就不必重复计算了：先由f(0)和f(1)计算f(2)，
* 再由f(1)和f(2)计算f(3)……以此类推就行了，计算第n个时，只要保存第n-1和第n-2项就可以了。
 * @Date 20:31 2019/4/17
 **/
public class TestFibonacci {


    //AC
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if ( n==1 ) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);

    }

    //更加好的解法
    public long Fib(long n) {
        if(n<0)
            throw new RuntimeException("下标错误，应从0开始！");
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long prePre = 0;
        long pre = 1;
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result = prePre + pre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }


}

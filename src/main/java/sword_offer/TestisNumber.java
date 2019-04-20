package sword_offer;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。

但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

注意:

小数可以没有整数部分，例如.123等于0.123；
小数点后面可以没有数字，例如233.等于233.0；
小数点前面和后面可以有数字，例如233.666;
当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4;
样例：
输入: "0"

输出: true
 * @Date 21:10 2019/4/20
 **/
public class TestisNumber {


    //Intuition
    //Method1: A valid number is in the form of A.B e/E A
    // (A: integer, B: unsigned integer), so it is helpful to break the problem down
    // to several components that can be solved individually. Detailed solution refer to: 表示数值的字符串
    //
    // Method2: Use some flags(eSeen, pointSeen, isNum) while scan each character in the String.
    // The solution is shown below.
    public boolean isNumber(String s) {

        if(s==null || s.length()<=0)
            return false;
        s=s.trim();
        boolean isNum=false;
        boolean pointSeen=false;
        boolean eSeen=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                if(i!=0 && s.charAt(i-1)!='e' && s.charAt(i-1)!='E')
                    return false;
            }else if(Character.isDigit(s.charAt(i))){
                isNum=true;
            }else if(s.charAt(i)=='.'){
                if(eSeen || pointSeen)
                    return false;
                pointSeen=true;
            }else if(s.charAt(i)=='e' || s.charAt(i)=='E' ){
                if(eSeen || !isNum)
                    return false;
                eSeen=true;
                isNum=false;
            }else
                return false;
        }
        return isNum;
    }

    public static void main(String[] args) {

    }
}

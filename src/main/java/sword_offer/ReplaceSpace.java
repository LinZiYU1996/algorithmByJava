package sword_offer;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 替换空格
 *
 * 实现一个函数  把字符串中的每个空格替换成 “%20”
 * 如：“We are happy”,则输出："We%20are%20happy"
 *
 *
 * 首先要询问面试官是新建一个字符串还是在原有的字符串上修改，本题要求在原有字符串上进行修改。

　　若从前往后依次替换，在每次遇到空格字符时，都需要移动后面O(n)个字符，对于含有O(n)个空格字符的字符串而言，总的时间效率为O(n2)。

　　转变思路：先计算出需要的总长度，然后从后往前进行复制和替换，，则每个字符只需要复制一次即可。时间效率为O(n)。
 *
 * @Date 20:23 2019/4/16
 **/
public class ReplaceSpace {



    //AC
    public static  String replaceSpaces(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0 ; i < str.length() ; i++){
            if (str.charAt(i) == 32) {
                stringBuffer.append("%20");
                continue;
            }
            stringBuffer.append(str.charAt(i));
        }
        return stringBuffer.toString();
    }

    //原数据基础上进行操作
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            System.out.println("输入错误！");
            return null;
        }
        int length = str.length();
        int indexOfOriginal = length-1;//指向原来str的结尾
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                length += 2;//计算空格数量
        }
        str.setLength(length);//扩容
        int indexOfNew = length-1;//指向扩容后的str的结尾
        while (indexOfNew > indexOfOriginal) {
            if (str.charAt(indexOfOriginal) != ' ') {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));//如果当前不是空格，就把当前字符复制到后面去
            } else {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }
            indexOfOriginal--;
        }
        return str.toString();
    }


    public static void main(String[] args) {
        char c = ' ';
        System.out.println((int)c);  //输出32
        StringBuffer buffer = new StringBuffer("we     are ok");
        System.out.println(replaceSpaces(buffer));



    }

}

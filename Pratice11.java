/*
获取一个字符串在另一个字符串中出现的次数。判断str2在str1中出现的次数
 */
import java.util.Scanner;

public class Pratice11 {
    public static void main(String[] args) {
        System.out.println("输入字符串池");
        Scanner supscanner = new Scanner(System.in);//读入字符串池
        String supstring = supscanner.nextLine();//字符串池
        System.out.println("输入目标字符串");
        Scanner subscanner = new Scanner(System.in);//读入目标字符串
        String substring = subscanner.nextLine();//目标字符串
        //计数器，记录出现次数
        int count = 0;
        //目标字符串长度
        int sublength = substring.length();
        //先将目标字符串的首字母进行匹配
        //然后再向后取目标字符串长度的字符串进行匹配
        for (int i = 0; i < supstring.length() - sublength + 1; i++) {
            if (supstring.charAt(i) == substring.charAt(0)) {
                System.out.println("找到可能的");
                if (supstring.substring(i,(i + sublength)).equals(substring)){
                    count++;
                }
            }
        }
        System.out.println("出现次数为：" + count);



    }
}

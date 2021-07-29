/*
模拟一个trim方法，去除字符串两端的空格。
 */
import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start ++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        System.out.println(s.subSequence(start,end + 1));
    }
}

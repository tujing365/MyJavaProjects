import java.util.Scanner;

/*
一个应用程序，接受用户输入的一行字符串，统计字符个数，然后反序输出。
 */
public class Practice9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s.length());
        for (int i = 0; i < (s.length()); i++) {
            char tempchar = s.charAt(s.length() - 1 - i);
            System.out.print(tempchar);
        }
    }


}

import java.util.Scanner;

/*
请编写一个 Application 实现如下功能：接受命令行中给出的一个字母串，
先将该串原样输出，然后判断该串的第一个字母是否为大写，
若是大写则统计该串中大写字母的个数，并将所有大写字母输出；
否则输出信息串”第一个字母不是大写字母!”。
 */
public class Practice8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        char firstchar = s.charAt(0);
        if (Character.isUpperCase(firstchar)) {
            for (int i = 0; i < s.length(); i++) {
                char tempchar = s.charAt(i);
                if (Character.isUpperCase(tempchar)) {
                    System.out.println(tempchar);
                }
            }
        } else {
            System.out.println("第一个字母不是大写");
        }
    }
}

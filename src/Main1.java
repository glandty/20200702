/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度大于等于2的子串重复
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 */

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String s = input.next();
            System.out.println(isPathRight(s));
        }
    }

    public static String isPathRight(String s) {
        if (s.length() <= 8)
            return "NG";
        boolean f1 = false, f2 = false, f3 = false, f4 = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                f1 = true;
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                f2 = true;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                f3 = true;
            if ((s.charAt(i) < 'A' || s.charAt(i) > 'Z') && (s.charAt(i) < 'a' || s.charAt(i) > 'z') && (s.charAt(i) < '0' || s.charAt(i) > '9'))
                f4 = true;
        }
        int count = 0;
        if (f1)
            count++;
        if (f2)
            count++;
        if (f3)
            count++;
        if (f4)
            count++;
        if (count < 3)
            return "NG";

        for (int i = 3; i <= s.length() / 2; i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String str1 = s.substring(j, j + i);
                String str2 = s.substring(j + i, s.length());
                if (str2.contains(str1))
                    return "NG";
            }
        }
        return "OK";
    }
}

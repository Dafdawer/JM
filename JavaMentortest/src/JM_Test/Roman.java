//import java.util.*;
//
//public class Roman {
//
//    static List ones = Arrays.asList("0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
//    static List tens = Arrays.asList("XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");
//
//    public static void doWhenInRome(String[] input) {
//
//        String a = input[0];
//        String b = input[2];
//        String operand = input[1];
//
//        try {
//            if (!isValidRoman(a, b)) {
//                throw new Main.MyException("Both digits must be either Roman or Arabic from 1 to 10 inclusive!!");
//            }
//        } catch (Main.MyException e) {
//            System.out.println(e.getMessage());
//            return;
//        }
//
//        try {
//            printRomanOuput(Main.getResult(romanToInt(a), operand, romanToInt(b)));
//        } catch (Main.MyException e) {
//            System.out.println(e.getMessage());
//            return;
//        }
//    }
//
//    static boolean isValidRoman (String a, String b) {
//        return ones.contains(a) && ones.contains(b);
//    }
//
//    static int romanToInt(String s) {
//        return ones.indexOf(s);
//    }
//
//    static void printRomanOuput(int a) {
//        if (a < 0) {
//            System.out.print("-");
//            a *= -1;
//        }
//        if (a <= 10) {
//            System.out.println(ones.get(a));
//        } else if (a > 10 && a < 20) {
//            System.out.printf("X%s", ones.get(a % 10));
//        } else if  (a % 10 == 0) {
//            System.out.println(tens.get((a / 10) - 2));
//        } else {
//            System.out.println(String.valueOf(tens.get((a / 10) - 2)) + ones.get(a % 10));
//        }
//    }
//}

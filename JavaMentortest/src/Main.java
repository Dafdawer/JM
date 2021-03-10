import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        System.out.println("Please input the operation:");
        String[] input = new Scanner(System.in).nextLine().split(" ");

        switch (checkTheWay(input)) {
            case "Arabic":
                Arabic.doItTheArabWay(input);
                break;
            case "Roman":
                Roman.doWhenInRome(input);
                break;
        }
    }

    static String checkTheWay(String[] input) {

        try {
            Integer.parseInt(input[0]);
            Integer.parseInt(input[2]);
            return "Arabic";
        } catch (NumberFormatException e) {
            return ("Roman");
        }
    }

    public enum Operation {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        NOTFOUND("not found");

        String operand;

        Operation(String operand) {
            this.operand = operand;
        }

        public static Operation findByOperand (String operand) {
            for (Operation value : values()) {
                if (operand.equals(value.operand)) {
                    return value;
                }
            }
            return NOTFOUND;
        }
    }

    public static int getResult(int a, String operand, int b) throws MyException {

        switch (Operation.findByOperand(operand)) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                try {
                    return a / b;
                } catch (ArithmeticException e) {
                    System.out.println("Division by zero!");    // unreachable since inputs can't be 0,
                    break;                                      // but just in case:)
                }
            case NOTFOUND:
                    throw new MyException("Wrong operand!");
        }
        return 0;
    }

    public static class MyException extends Exception {
        public MyException(String message){
            super(message);
        }
    }
    static boolean isValidInput(int a, int b) {
        return (a > 0 && a <= 10) && (b > 0 && b <= 10);
    }
}

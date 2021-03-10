
public class Arabic {
    public static void doItTheArabWay(String[] input) throws Main.MyException {

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[2]);
        String operand = input[1];

        try {
            if (!Main.isValidInput(a, b)) {
                throw new Main.MyException("Both digits must be from 1 to 10 inclusive!");
            }
        } catch (Main.MyException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            System.out.println(Main.getResult(a, operand, b));
        } catch (Main.MyException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}

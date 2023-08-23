public class AddStrings {
    public String addStrings(String num1, String num2) {
        int digit = 0;
        int curDigit;
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            curDigit = digit;
            if (p1 >= 0) {
                curDigit += num1.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                curDigit += num2.charAt(p2) - '0';
                p2--;
            }
            digit = curDigit / 10;
            sb.append((char) ('0' + curDigit % 10));
        }

        if (digit == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        AddStrings sol = new AddStrings();

        String num1 = "6913259244";
        String num2 = "71103343";
        System.out.println(sol.addStrings(num1, num2));
        System.out.println((double)52/709);
        System.out.println((double)99/1500);
        System.out.println((double)30/622);
    }


}

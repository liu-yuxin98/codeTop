public class StringToInt {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') { // skipping space characters at the beginning
            i++;
        }

        int positive = 0;
        int negative = 0;

        if (i<n && s.charAt(i) == '+') {
            positive++; // number of positive signs at the start in string
            i++;
        }

        if (i<n && s.charAt(i) == '-') {
            negative++; // number of negative signs at the start in string
            i++;
        }

        double ans = 0;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans = ans * 10 + (s.charAt(i) - '0'); // (s.charAt(i) - '0') is converting character to integer
            i++;
        }

        if (negative > 0) { // if negative sign exists
            ans = -ans;
        }
        if (positive > 0 && negative > 0) { // if both +ve and -ve sign exist, Example: +-12
            return 0;
        }

        int INT_MAX = (int) Math.pow(2, 31) - 1;
        int INT_MIN = (int) Math.pow(-2, 31);

        if (ans > INT_MAX) { // if ans > 2^31 - 1
            ans = INT_MAX;
        }

        if (ans < INT_MIN) { // if ans < -2^31
            ans = INT_MIN;
        }

        return (int) ans;
    }


    public static void main(String[] args) {
        StringToInt sol = new StringToInt();
        String s = "-6147483648";
        System.out.println(sol.myAtoi(s));
        System.out.println(-(int)Math.pow(2,31)-1);
    }
}

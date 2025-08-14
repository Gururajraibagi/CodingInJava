package begineer.bit_manipulation;

public class basic {
    public static void main(String[] args) {
        decimalToBinary(10);
    }

    public static void decimalToBinary(int n) {

        StringBuilder str = new StringBuilder();
        while (n > 1) {
            str.append(n % 2);
            n = n / 2;
        }
        str.append(n);
        str.reverse();
        System.out.println(str);
        binaryToDecimal(str.toString());
        /* String s = == true ? "even" : "odd"; */
        System.out.println("n:" + n + "-" + evenOrOdd(n));


    }

    public static void binaryToDecimal(String s) {

        int len = s.length();
        int sum = 0;
        int p2 = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                sum = sum + p2;
            p2 *= 2;
        }

        /*
         * while (n > 1) { str.append(n % 2); n = n / 2; } str.append(n); str.reverse();
         */
        System.out.println(sum);
    }

    public static boolean evenOrOdd(int n) {
        if ((n & 1) == 0) {
            return true;
        } else
            return false;

    }


}


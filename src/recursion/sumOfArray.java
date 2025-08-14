package recursion;

public class sumOfArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};// 6, 7, 8, 9};
        // int a = sumOfArr(arr, arr.length - 1);
        // int a = sumOfN(5);
        // int a = Factorial(3);
        // int a = SumOfEven(10);
        // int b = CountOfEven(10);
        PrintNToOne(10);
        System.out.println("__________________________________");
        PrintOneToN(10);
        // System.out.println("A = " + a);
        // System.out.println("B = " + b);
    }

    public static int sumOfArr(int[] arr, int n) {
        if (n == 0)
            return arr[0];
        return arr[n] + sumOfArr(arr, n - 1);
    }

    public static int sumOfN(int n) {
        if (n == 0)
            return 0;
        return n + sumOfN(n - 1);
    }

    public static int Factorial(int n) {
        if (n == 0)
            return 1;
        return n * Factorial(n - 1);
    }

    public static int SumOfEven(int n) {
        if (n <= 0)
            return 0;
        if ((n % 2) == 0)
            return n + SumOfEven(n - 1);
        else
            return 0 + SumOfEven(n - 1);
    }

    public static int CountOfEven(int n) {
        if (n <= 0)
            return 0;
        if ((n % 2) == 0)
            return 1 + CountOfEven(n - 1);
        else
            return 0 + CountOfEven(n - 1);
    }

    public static void PrintOneToN(int n) {
        if (n == 0)
            return;
        PrintOneToN(n - 1);
        System.out.println(n);
    }

    public static void PrintNToOne(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        PrintNToOne(n - 1);
    }

}

package recursion;

import java.util.List;

public class stringPermutation {
    static StringBuilder result;

    public static void main(String[] args) {
        stringPermutation permutation = new stringPermutation();
        result = new StringBuilder();
        permutation.permutatation("abc", "");
        // sSystem.out.println(result.toString());
    }

    public void permutatation(String str, String res) {

        if (str.length() == 0) {
            result.append(res);
            System.out.println(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            permutatation(left + right, res + ch);
        }
    }

    public void numberPermutatation(String str, List<Integer> res) {

        if (str.length() == 0) {
            result.append(res);
            System.out.println(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            permutatation(left + right, res + ch);
        }
    }
}

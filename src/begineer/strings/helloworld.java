package begineer.strings;

public class helloworld {

    public static void main(String[] args) {

    }

    public static boolean getIndexOfString(String str, String pattern) {
        // String str = "Hello world";
        // String pattern = "wor";
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(i) == pattern.indexOf(index)) {
                index++;
            } else
                index = 0;
        }
        return index == pattern.length();
    }

    public boolean repeatedSubstringPattern(String s) {


        int maxlen = s.length();
        int[] count = new int[maxlen];
        count[0] = 0;
        int len = 0;
        int i = 1;

        while (i < maxlen) {
            if (s.charAt(i) == s.charAt(len)) {
                len = len + 1;
                count[i] = len;
                i = i + 1;
            } else {
                if (len > 0) {
                    len = count[len - 1];
                } else {// len <= 0
                    count[i] = 0;
                    i++;
                }
            }
        }
        int last = count[maxlen - 1];


        return last > 0 && (maxlen % (maxlen - len) == 0);

    }

    public static int strStr(String haystack, String needle) {
        int len = haystack.length();
        for (int i = 0; i < len; i++) {

            int j = 0;
            int k = i;
            for (j = 0; j < needle.length(); j++) {
                char c1 = haystack.charAt(k);
                char c2 = needle.charAt(j);
                if (c1 == c2) {
                    k++;
                    continue;

                } else
                    break;
            }
            System.out.println("j = " + j);
            System.out.println("j = " + j);
            if (j == needle.length())
                return 0;
        }
        return -1;
    }
}

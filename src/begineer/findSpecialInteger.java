package begineer;

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr));
    }

    public static int findSpecialInteger(int[] arr) {


        int percentCount = (int) (arr.length * 0.25);
        int index = 0;
        int frontPointer = index + percentCount;

        while (frontPointer < arr.length) {
            if (arr[frontPointer] == arr[index]) {
                return arr[index];
            }
            index++;
            frontPointer = index + percentCount;
        }
        return -1;
    }
}

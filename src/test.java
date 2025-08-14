import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        System.out.println(map.get());
    }
}

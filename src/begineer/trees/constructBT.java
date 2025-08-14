package begineer.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.swing.tree.TreeNode;

public class constructBT {

    public void insertLeft(MyTreenode root) {

    }

    public MyTreenode createNode(int val) {
        MyTreenode node = new MyTreenode(val);
        node.left = null;
        node.right = null;
        return node;
    }

    public static void main(String[] args) {
        constructBT oBt = new constructBT();
        MyTreenode n1 = oBt.createNode(10);
        MyTreenode n2 = oBt.createNode(20);
        MyTreenode n3 = oBt.createNode(30);
        MyTreenode n4 = oBt.createNode(40);
        MyTreenode n5 = oBt.createNode(50);
        MyTreenode n6 = oBt.createNode(60);
        MyTreenode n7 = oBt.createNode(70);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n3.left = n7;

        // oBt.dfs(n1, "/\\");
        oBt.printInOrder(n1);
        List<Integer> list = new ArrayList<>();
    }

    public void dfs(MyTreenode root, String dir) {

        if (root == null)
            return;
        System.out.println(root.val);
        System.out.println(dir);
        dfs(root.left, "/");
        dfs(root.right, "\\");
        List<Integer> list = new ArrayList<>(4);
        List<Integer> list2 = new ArrayList<>();


    }

    public class InnerconstructBT {
        MyTreenode node;
        int index;

        public InnerconstructBT(MyTreenode node, int index) {
            this.node = node;
            this.index = index;
        }

    }

    public void printInOrder(MyTreenode root) {

        Queue<InnerconstructBT> queue = new LinkedList<>();
        queue.offer(new InnerconstructBT(root, 0));

        HashMap<Integer, MyTreenode> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int val = queue.size();
            List<Integer> lst = new ArrayList<>();

            while (val-- > 0) {

                InnerconstructBT node = queue.poll();
                int sizeIndex = node.index;
                lst.add(node.node.val);
                if (!map.containsKey(sizeIndex)) {
                    map.put(sizeIndex, node.node);
                }
                if (node.node.left != null)
                    queue.offer(new InnerconstructBT(node.node.left, sizeIndex + 1));

                if (node.node.right != null)
                    queue.offer(new InnerconstructBT(node.node.right, sizeIndex - 1));
            }
            System.out.println(lst);
        }

        System.out.println("");
        for (Map.Entry<Integer, MyTreenode> ele : map.entrySet()) {
            System.out.print(ele.getValue().val + " ");
        }

    }
}

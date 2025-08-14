
import java.util.*;
import java.util.function.IntPredicate;

/**
 * SDE2Templates ------------- Interview-ready Java templates for common patterns & data structures.
 * Copy/paste the pieces you need, or compile this whole file.
 *
 * Compile: javac SDE2Templates.java
 *
 * Contents: - Arrays & Search: binary search, firstTrue (answer-space), Kadane, Moore, Dutch flag -
 * Sliding Window: fixed-size, min window substring - Prefix Sum / Hashing: subarray sum equals K -
 * Stacks / Monotonic: next greater element, largest rectangle in histogram - Graphs: BFS on grid,
 * Dijkstra, Bellman-Ford, Kahn topo, Union-Find (DSU) - Trees: iterative inorder, Morris inorder,
 * LCA (binary lifting) - Strings: Trie, KMP (prefix/pi) + search - Design DS: LRU (hash map + DLL)
 * - DP & Greedy: 0/1 knapsack, LIS (n log n), edit distance, interval scheduling - MST: Kruskal,
 * Prim - Math / Bits: gcd, egcd, sieve, floyd-warshall, power-of-two, popcount - Graph coloring /
 * Bipartite; Eulerian trail check (undirected)
 */
public class Templates {

    // ------------------------------
    // Arrays & Binary Search
    // ------------------------------

    /** Vanilla binary search: returns index of target or -1. */
    public static int binarySearch(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >>> 1);
            if (a[m] == target)
                return m;
            if (a[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    /**
     * Answer-space binary search: find smallest x in [lo, hi] s.t. check(x) is true; returns hi+1
     * if none.
     */
    public static int firstTrue(int lo, int hi, IntPredicate check) {
        int ans = hi + 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            if (check.test(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    /** Kadane's algorithm: maximum subarray sum (int -> long to reduce overflow risk). */
    public static long maxSubarraySum(int[] nums) {
        if (nums.length == 0)
            return 0;
        long best = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            best = Math.max(best, cur);
        }
        return best;
    }

    /** Moore's Voting: majority element candidate. Verify if required. */
    public static int majorityElement(int[] nums) {
        int cand = 0, count = 0;
        for (int x : nums) {
            if (count == 0)
                cand = x;
            count += (x == cand) ? 1 : -1;
        }
        return cand;
    }

    /** Dutch National Flag: 3-way partition around pivot value. */
    public static void dutchFlag(int[] a, int pivot) {
        int lt = 0, i = 0, gt = a.length - 1;
        while (i <= gt) {
            if (a[i] < pivot) {
                swap(a, lt++, i++);
            } else if (a[i] > pivot) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // ------------------------------
    // Sliding Window
    // ------------------------------

    /** Fixed-size window: maximum sum of any subarray of size k. */
    public static long maxSumFixedK(int[] a, int k) {
        if (k <= 0 || k > a.length)
            return 0;
        long sum = 0;
        for (int i = 0; i < k; i++)
            sum += a[i];
        long ans = sum;
        for (int i = k; i < a.length; i++) {
            sum += a[i] - a[i - k];
            if (sum > ans)
                ans = sum;
        }
        return ans;
    }

    /** Variable-size window: minimum window substring covering all chars of t. */
    public static String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length())
            return "";
        int[] need = new int[128];
        int required = 0;
        for (char c : t.toCharArray()) {
            if (need[c] == 0)
                required++;
            need[c]++;
        }
        int formed = 0;
        int[] have = new int[128];
        int l = 0, bestL = 0, bestLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            have[c]++;
            if (have[c] == need[c] && need[c] > 0)
                formed++;
            while (formed == required) {
                if (r - l + 1 < bestLen) {
                    bestLen = r - l + 1;
                    bestL = l;
                }
                char lc = s.charAt(l++);
                have[lc]--;
                if (need[lc] > 0 && have[lc] < need[lc])
                    formed--;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }

    // ------------------------------
    // Prefix Sum / Hashing
    // ------------------------------

    /** Count subarrays with sum == k (supports large sums via long). */
    public static long countSubarraysSumK(int[] a, long k) {
        Map<Long, Integer> seen = new HashMap<>();
        seen.put(0L, 1);
        long acc = 0, ans = 0;
        for (int x : a) {
            acc += x;
            ans += seen.getOrDefault(acc - k, 0);
            seen.put(acc, seen.getOrDefault(acc, 0) + 1);
        }
        return ans;
    }

    // ------------------------------
    // Monotonic Stack
    // ------------------------------

    /** Next greater element to the right; returns array of same length (or -1). */
    public static int[] nextGreater(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>(); // holds indices, increasing stack by value
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] < a[i]) {
                ans[st.pop()] = a[i];
            }
            st.push(i);
        }
        return ans;
    }

    /** Largest rectangle in histogram (heights >= 0). */
    public static long largestRectangleArea(int[] h) {
        long best = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= h.length; i++) {
            int cur = (i == h.length) ? 0 : h[i];
            while (!st.isEmpty() && h[st.peek()] > cur) {
                int height = h[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                long width = i - left - 1L;
                best = Math.max(best, width * height);
            }
            st.push(i);
        }
        return best;
    }

    // ------------------------------
    // Graphs: BFS on grid
    // ------------------------------

    /**
     * Shortest path in a binary grid (4-dir), 0=open, 1=blocked. Returns length or -1. Start=(0,0),
     * goal=(n-1,m-1).
     */
    public static int shortestPathGrid(int[][] grid) {
        int n = grid.length;
        if (n == 0)
            return -1;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[n][m];
        q.offer(new int[] {0, 0, 1});
        seen[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (r == n - 1 && c == m - 1)
                return d;
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0 && !seen[nr][nc]) {
                    seen[nr][nc] = true;
                    q.offer(new int[] {nr, nc, d + 1});
                }
            }
        }
        return -1;
    }

    // ------------------------------
    // Linked List & Trees
    // ------------------------------

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {}

        public ListNode(int v) {
            this.val = v;
        }

        public ListNode(int v, ListNode n) {
            this.val = v;
            this.next = n;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    /** Floyd cycle detection in linked list. */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int v) {
            this.val = v;
        }

        public TreeNode(int v, TreeNode l, TreeNode r) {
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }

    /** Iterative inorder traversal. */
    public static List<Integer> inorderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /** Morris inorder traversal (O(1) space). */
    public static List<Integer> morrisInorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    // ------------------------------
    // LCA via Binary Lifting on a Tree (0..n-1)
    // ------------------------------

    public static class LCA {
        private final int n;
        private final int LOG;
        private final int[][] up;
        private final int[] depth;
        private final List<List<Integer>> adj;

        public LCA(int n) {
            this.n = n;
            this.LOG = 1 + Integer.numberOfTrailingZeros(Integer.highestOneBit(Math.max(1, n)));
            this.up = new int[LOG][n];
            for (int[] row : up)
                Arrays.fill(row, -1);
            this.depth = new int[n];
            this.adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        public void build(int root) {
            dfs(root, -1);
            for (int k = 1; k < LOG; k++) {
                for (int v = 0; v < n; v++) {
                    int prev = up[k - 1][v];
                    up[k][v] = (prev == -1) ? -1 : up[k - 1][prev];
                }
            }
        }

        private void dfs(int u, int p) {
            up[0][u] = p;
            for (int v : adj.get(u))
                if (v != p) {
                    depth[v] = depth[u] + 1;
                    dfs(v, u);
                }
        }

        public int lca(int u, int v) {
            if (depth[u] < depth[v]) {
                int t = u;
                u = v;
                v = t;
            }
            int diff = depth[u] - depth[v];
            for (int k = 0; k < LOG; k++)
                if (((diff >> k) & 1) == 1)
                    u = up[k][u];
            if (u == v)
                return u;
            for (int k = LOG - 1; k >= 0; k--)
                if (up[k][u] != up[k][v]) {
                    u = up[k][u];
                    v = up[k][v];
                }
            return up[0][u];
        }
    }

    // ------------------------------
    // Graph Algorithms
    // ------------------------------

    public static class Edge {
        public int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    /** Dijkstra: graph as adjacency list of weighted edges. Returns distances (long). */
    public static long[] dijkstra(int n, List<List<Edge>> g, int src) {
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[] {0, src});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d != dist[u])
                continue;
            for (Edge e : g.get(u)) {
                long nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[] {nd, e.to});
                }
            }
        }
        return dist;
    }

    public static class WEdge {
        public int u, v, w;

        public WEdge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    /** Bellman-Ford: edges list; handles negative weights. */
    public static long[] bellmanFord(int n, List<WEdge> edges, int src) {
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean changed = false;
            for (WEdge e : edges) {
                if (dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    changed = true;
                }
            }
            if (!changed)
                break;
        }
        return dist;
    }

    /** Kahn's topological sort for DAG. Returns empty list if cycle exists. */
    public static List<Integer> topoKahn(int n, List<List<Integer>> adj) {
        int[] indeg = new int[n];
        for (int u = 0; u < n; u++)
            for (int v : adj.get(u))
                indeg[v]++;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indeg[i] == 0)
                q.offer(i);
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : adj.get(u))
                if (--indeg[v] == 0)
                    q.offer(v);
        }
        return (order.size() == n) ? order : Collections.emptyList();
    }

    /** Disjoint Set Union (Union-Find) with path compression & union by rank. */
    public static class UnionFind {
        int[] p, r;
        int sets;

        public UnionFind(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = i;
            sets = n;
        }

        public int find(int x) {
            while (x != p[x]) {
                p[x] = p[p[x]];
                x = p[x];
            }
            return x;
        }

        public boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb)
                return false;
            if (r[ra] < r[rb]) {
                int t = ra;
                ra = rb;
                rb = t;
            }
            p[rb] = ra;
            if (r[ra] == r[rb])
                r[ra]++;
            sets--;
            return true;
        }
    }

    // ------------------------------
    // Trie
    // ------------------------------

    public static class Trie {
        private static class Node {
            Node[] child = new Node[26];
            boolean end;
        }

        private final Node root = new Node();

        public void insert(String word) {
            Node cur = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (i < 0 || i >= 26)
                    throw new IllegalArgumentException("lowercase a-z only in this template");
                if (cur.child[i] == null)
                    cur.child[i] = new Node();
                cur = cur.child[i];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            Node cur = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (i < 0 || i >= 26)
                    return false;
                if (cur.child[i] == null)
                    return false;
                cur = cur.child[i];
            }
            return cur.end;
        }

        public boolean startsWith(String prefix) {
            Node cur = root;
            for (char ch : prefix.toCharArray()) {
                int i = ch - 'a';
                if (i < 0 || i >= 26)
                    return false;
                if (cur.child[i] == null)
                    return false;
                cur = cur.child[i];
            }
            return true;
        }
    }

    // ------------------------------
    // KMP String Matching
    // ------------------------------

    /** Prefix-function (pi array). */
    public static int[] kmpPrefix(String s) {
        int n = s.length();
        int[] pi = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            pi[i] = j;
        }
        return pi;
    }

    /** KMP search: returns first index of pattern in text or -1. */
    public static int kmpSearch(String text, String pattern) {
        if (pattern.isEmpty())
            return 0;
        int[] pi = kmpPrefix(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == pattern.length())
                    return i - j + 1;
            }
        }
        return -1;
    }

    // ------------------------------
    // LRU Cache (HashMap + Doubly Linked List)
    // ------------------------------

    public static class LRUCache {
        private static class Node {
            int k, v;
            Node prev, next;

            Node() {}

            Node(int k, int v) {
                this.k = k;
                this.v = v;
            }
        }

        private final int cap;
        private final Map<Integer, Node> map;
        private final Node head, tail;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.map = new HashMap<>();
            this.head = new Node();
            this.tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        private void remove(Node x) {
            Node p = x.prev, n = x.next;
            p.next = n;
            n.prev = p;
        }

        private void addFront(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
        }

        public int get(int key) {
            Node x = map.get(key);
            if (x == null)
                return -1;
            remove(x);
            addFront(x);
            return x.v;
        }

        public void put(int key, int value) {
            Node x = map.get(key);
            if (x != null) {
                x.v = value;
                remove(x);
                addFront(x);
            } else {
                if (map.size() == cap) {
                    Node lru = tail.prev;
                    remove(lru);
                    map.remove(lru.k);
                }
                Node n = new Node(key, value);
                addFront(n);
                map.put(key, n);
            }
        }
    }

    // ------------------------------
    // Greedy, DP, LIS, Edit Distance
    // ------------------------------

    /** Interval scheduling (max non-overlapping by end time). intervals = [ [start,end], ... ] */
    public static int maxNonOverlapping(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        int cnt = 0, end = Integer.MIN_VALUE;
        for (int[] it : intervals) {
            if (it[0] >= end) {
                cnt++;
                end = it[1];
            }
        }
        return cnt;
    }

    /** 0/1 Knapsack (1D DP). */
    public static int knapsack01(int[] w, int[] val, int W) {
        int n = w.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int cap = W; cap >= w[i]; cap--) {
                dp[cap] = Math.max(dp[cap], dp[cap - w[i]] + val[i]);
            }
        }
        return dp[W];
    }

    /** LIS length in O(n log n) (patience sorting). */
    public static int lisLength(int[] a) {
        int[] tails = new int[a.length];
        int size = 0;
        for (int x : a) {
            int i = Arrays.binarySearch(tails, 0, size, x);
            if (i < 0)
                i = -i - 1;
            tails[i] = x;
            if (i == size)
                size++;
        }
        return size;
    }

    /** Edit distance (Levenshtein). */
    public static int editDistance(String A, String B) {
        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }

    // ------------------------------
    // MST: Kruskal & Prim
    // ------------------------------

    /** Kruskal MST total weight; return -1 if not connected. */
    public static long kruskalMST(int n, List<WEdge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.w));
        UnionFind uf = new UnionFind(n);
        long total = 0;
        int taken = 0;
        for (WEdge e : edges) {
            if (uf.union(e.u, e.v)) {
                total += e.w;
                taken++;
                if (taken == n - 1)
                    break;
            }
        }
        return (taken == n - 1) ? total : -1;
    }

    /** Prim MST for connected graph (0..n-1). Returns total weight or -1 if disconnected. */
    public static long primMST(int n, List<List<Edge>> g) {
        boolean[] seen = new boolean[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
        pq.offer(new long[] {0, 0});
        long res = 0;
        int taken = 0;
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long w = cur[0];
            int u = (int) cur[1];
            if (seen[u])
                continue;
            seen[u] = true;
            res += w;
            taken++;
            for (Edge e : g.get(u)) {
                if (!seen[e.to])
                    pq.offer(new long[] {e.w, e.to});
            }
        }
        return (taken == n) ? res : -1;
    }

    // ------------------------------
    // Math & Bits
    // ------------------------------

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    /** Extended GCD: returns [g, x, y] s.t. ax + by = g = gcd(a,b). */
    public static long[] egcd(long a, long b) {
        if (b == 0)
            return new long[] {a, 1, 0};
        long[] t = egcd(b, a % b);
        long g = t[0], x1 = t[1], y1 = t[2];
        return new long[] {g, y1, x1 - (a / b) * y1};
    }

    /** Sieve of Eratosthenes: isPrime[0..n]. */
    public static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        if (n >= 0)
            prime[0] = false;
        if (n >= 1)
            prime[1] = false;
        for (int p = 2; p * p <= n; p++)
            if (prime[p]) {
                for (int q = p * p; q <= n; q += p)
                    prime[q] = false;
            }
        return prime;
    }

    /** Floyd-Warshall on dense graph; mutates and returns dist matrix. */
    public static long[][] floydWarshall(long[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    public static boolean isPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }

    public static int popcount(int x) {
        int c = 0;
        while (x != 0) {
            x &= (x - 1);
            c++;
        }
        return c;
    }

    // ------------------------------
    // Graph Coloring / Bipartite / Eulerian Trail
    // ------------------------------

    /** BFS 2-coloring bipartite test. */
    public static boolean isBipartite(int n, List<List<Integer>> g) {
        int[] color = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int s = 0; s < n; s++)
            if (color[s] == 0) {
                color[s] = 1;
                q.offer(s);
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : g.get(u)) {
                        if (color[v] == 0) {
                            color[v] = -color[u];
                            q.offer(v);
                        } else if (color[v] == color[u])
                            return false;
                    }
                }
            }
        return true;
    }

    /**
     * Eulerian trail existence in an undirected graph: - Graph is connected ignoring 0-degree nodes
     * - #odd-degree nodes is 0 or 2
     */
    public static boolean hasEulerianTrailUndirected(int n, List<List<Integer>> g) {
        int[] deg = new int[n];
        for (int u = 0; u < n; u++)
            deg[u] = g.get(u).size();
        int odd = 0, start = -1;
        for (int i = 0; i < n; i++) {
            if (deg[i] % 2 == 1)
                odd++;
            if (deg[i] > 0)
                start = i;
        }
        if (start == -1)
            return true; // empty graph has trail
        if (!(odd == 0 || odd == 2))
            return false;
        // check connectivity ignoring zero-degree nodes
        boolean[] seen = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        seen[start] = true;
        int reached = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            reached++;
            for (int v : g.get(u))
                if (!seen[v]) {
                    seen[v] = true;
                    q.offer(v);
                }
        }
        for (int i = 0; i < n; i++)
            if (deg[i] > 0 && !seen[i])
                return false;
        return true;
    }

    // ------------------------------
    // Helpers to quickly build graphs
    // ------------------------------

    /** Utility: build empty adjacency list (n nodes). */
    public static List<List<Integer>> buildAdj(int n) {
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());
        return g;
    }

    /** Utility: build weighted adjacency list (n nodes). */
    public static List<List<Edge>> buildWeightedAdj(int n) {
        List<List<Edge>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());
        return g;
    }
}

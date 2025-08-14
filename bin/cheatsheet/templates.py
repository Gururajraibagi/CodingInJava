
# SDE-2 Coding Templates (Python)
# -------------------------------
# These are concise, interview-ready skeletons for common patterns.
# Fill in details and practice writing them from memory (no peeking!).

from collections import deque, defaultdict, Counter, OrderedDict
import heapq
import math

# --- Binary Search (vanilla) ---
def binary_search(nums, target):
    l, r = 0, len(nums) - 1
    while l <= r:
        m = (l + r) // 2
        if nums[m] == target:
            return m
        if nums[m] < target:
            l = m + 1
        else:
            r = m - 1
    return -1

# --- Binary Search (first true / lower_bound style) ---
def first_true(lo, hi, check):
    # find smallest x in [lo, hi] s.t. check(x) is True
    ans = hi + 1
    while lo <= hi:
        mid = (lo + hi) // 2
        if check(mid):
            ans = mid
            hi = mid - 1
        else:
            lo = mid + 1
    return ans

# --- Kadane's Algorithm ---
def max_subarray_sum(nums):
    best = cur = -10**18
    for x in nums:
        cur = max(x, cur + x)
        best = max(best, cur)
    return best

# --- Moore’s Voting Algorithm ---
def majority_element(nums):
    count = cand = 0
    for x in nums:
        if count == 0:
            cand = x
        count += 1 if x == cand else -1
    # verify cand if problem requires
    return cand

# --- Dutch National Flag (3-way partition) ---
def dutch_flag(nums, pivot=1):
    lt, i, gt = 0, 0, len(nums) - 1
    while i <= gt:
        if nums[i] < pivot:
            nums[lt], nums[i] = nums[i], nums[lt]
            lt += 1; i += 1
        elif nums[i] > pivot:
            nums[gt], nums[i] = nums[i], nums[gt]
            gt -= 1
        else:
            i += 1
    return nums

# --- Sliding Window (fixed size example: max sum subarray of size k) ---
def max_sum_fixed_k(nums, k):
    s = sum(nums[:k])
    ans = s
    for i in range(k, len(nums)):
        s += nums[i] - nums[i-k]
        if s > ans:
            ans = s
    return ans

# --- Sliding Window (variable size: min window substring) ---
def min_window(s, t):
    need = Counter(t); missing = len(t)
    i = start = end = 0
    for j, ch in enumerate(s, 1):
        if need[ch] > 0:
            missing -= 1
        need[ch] -= 1
        if missing == 0:
            while i < j and need[s[i]] < 0:
                need[s[i]] += 1; i += 1
            if end == 0 or j - i < end - start:
                start, end = i, j
            need[s[i]] += 1; i += 1; missing += 1
    return s[start:end]

# --- Prefix Sum (subarray sum equals k) ---
def count_subarrays_sum_k(nums, k):
    acc = 0
    seen = defaultdict(int); seen[0] = 1
    ans = 0
    for x in nums:
        acc += x
        ans += seen[acc - k]
        seen[acc] += 1
    return ans

# --- Monotonic Stack (Next Greater Element) ---
def next_greater(nums):
    ans = [-1]*len(nums)
    st = []
    for i, x in enumerate(nums):
        while st and nums[st[-1]] < x:
            ans[st.pop()] = x
        st.append(i)
    return ans

# --- Largest Rectangle in Histogram (monotonic stack) ---
def largest_rectangle_area(heights):
    st = []
    ans = 0
    for i, h in enumerate(heights + [0]):
        while st and heights[st[-1]] > h:
            H = heights[st.pop()]
            L = st[-1] if st else -1
            ans = max(ans, H * (i - L - 1))
        st.append(i)
    return ans

# --- BFS on Grid (shortest path 8-dir example) ---
def shortest_path_grid(mat):
    n = len(mat)
    if n == 0 or mat[0][0] or mat[-1][-1]: return -1
    q = deque([(0,0,1)])
    seen = {(0,0)}
    dirs = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
    while q:
        r,c,d = q.popleft()
        if (r,c) == (n-1,n-1): return d
        for dr,dc in dirs:
            nr,nc = r+dr, c+dc
            if 0<=nr<n and 0<=nc<n and not mat[nr][nc] and (nr,nc) not in seen:
                seen.add((nr,nc)); q.append((nr,nc,d+1))
    return -1

# --- Linked List (reverse + cycle detect) ---
class ListNode:
    def __init__(self, val=0, next=None):
        self.val, self.next = val, next

def reverse_list(head):
    prev = None
    cur = head
    while cur:
        nxt = cur.next
        cur.next = prev
        prev = cur
        cur = nxt
    return prev

def has_cycle(head):
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            return True
    return False

# --- Tree Traversals ---
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val, self.left, self.right = val, left, right

def inorder_iter(root):
    res, st = [], []
    cur = root
    while cur or st:
        while cur:
            st.append(cur); cur = cur.left
        cur = st.pop()
        res.append(cur.val)
        cur = cur.right
    return res

# --- Dijkstra (adj list: u -> list[(v, w)]) ---
def dijkstra(n, graph, src=0):
    INF = 10**18
    dist = [INF]*n; dist[src] = 0
    pq = [(0, src)]
    while pq:
        d,u = heapq.heappop(pq)
        if d != dist[u]: continue
        for v,w in graph[u]:
            nd = d + w
            if nd < dist[v]:
                dist[v] = nd
                heapq.heappush(pq, (nd, v))
    return dist

# --- Bellman-Ford ---
def bellman_ford(n, edges, src=0):
    INF = 10**18
    dist = [INF]*n; dist[src] = 0
    for _ in range(n-1):
        changed = False
        for u,v,w in edges:
            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w; changed = True
        if not changed: break
    # Negative-cycle check if needed
    return dist

# --- Union-Find (Disjoint Set Union) ---
class UnionFind:
    def __init__(self, n):
        self.p = list(range(n))
        self.r = [0]*n
        self.sets = n
    def find(self, x):
        while x != self.p[x]:
            self.p[x] = self.p[self.p[x]]
            x = self.p[x]
        return x
    def union(self, a, b):
        ra, rb = self.find(a), self.find(b)
        if ra == rb: return False
        if self.r[ra] < self.r[rb]: ra, rb = rb, ra
        self.p[rb] = ra
        if self.r[ra] == self.r[rb]: self.r[ra] += 1
        self.sets -= 1
        return True

# --- Topological Sort (Kahn) ---
def topo_kahn(n, adj):
    indeg = [0]*n
    for u in range(n):
        for v in adj[u]:
            indeg[v] += 1
    q = deque([i for i,d in enumerate(indeg) if d==0])
    order = []
    while q:
        u = q.popleft()
        order.append(u)
        for v in adj[u]:
            indeg[v] -= 1
            if indeg[v] == 0:
                q.append(v)
    return order if len(order)==n else []

# --- Trie ---
class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    def insert(self, word):
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                cur.children[ch] = TrieNode()
            cur = cur.children[ch]
        cur.end = True
    def search(self, word):
        cur = self.root
        for ch in word:
            if ch not in cur.children: return False
            cur = cur.children[ch]
        return cur.end
    def startsWith(self, prefix):
        cur = self.root
        for ch in prefix:
            if ch not in cur.children: return False
            cur = cur.children[ch]
        return True

# --- KMP Prefix Function (pi array) ---
def kmp_prefix(s):
    n = len(s); pi = [0]*n
    j = 0
    for i in range(1, n):
        while j and s[i] != s[j]:
            j = pi[j-1]
        if s[i] == s[j]:
            j += 1
        pi[i] = j
    return pi

# --- LRU Cache (hash map + doubly linked list) ---
class DLNode:
    def __init__(self, k=0, v=0):
        self.k, self.v = k, v
        self.prev = self.next = None

class LRUCache:
    def __init__(self, capacity: int):
        self.cap = capacity
        self.map = {}
        self.head, self.tail = DLNode(), DLNode()
        self.head.next = self.tail; self.tail.prev = self.head
    def _remove(self, node):
        p, n = node.prev, node.next
        p.next = n; n.prev = p
    def _add_front(self, node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node
    def get(self, key: int) -> int:
        if key not in self.map: return -1
        node = self.map[key]
        self._remove(node); self._add_front(node)
        return node.v
    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]; node.v = value
            self._remove(node); self._add_front(node)
        else:
            if len(self.map) == self.cap:
                lru = self.tail.prev
                self._remove(lru); self.map.pop(lru.k, None)
            node = DLNode(key, value)
            self._add_front(node); self.map[key] = node

# --- Bit tricks ---
def is_power_of_two(x):
    return x > 0 and (x & (x-1)) == 0

def popcount(x):
    c = 0
    while x:
        x &= x-1; c += 1
    return c

# --- GCD / Extended GCD / Sieve ---
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def egcd(a, b):
    if b == 0: return (a, 1, 0)
    g, x1, y1 = egcd(b, a % b)
    return (g, y1, x1 - (a//b)*y1)

def sieve(n):
    is_prime = [True]*(n+1)
    is_prime[:2] = [False, False]
    for p in range(2, int(n**0.5)+1):
        if is_prime[p]:
            for q in range(p*p, n+1, p):
                is_prime[q] = False
    return is_prime

# --- Floyd Warshall (all-pairs shortest paths) ---
def floyd_warshall(dist):
    n = len(dist)
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    return dist

# --- Tree LCA (binary lifting precompute outline) ---
def build_lift(n, root, adj, LOG=20):
    up = [[-1]*n for _ in range(LOG)]
    depth = [0]*n
    def dfs(u, p):
        up[0][u] = p
        for v in adj[u]:
            if v == p: continue
            depth[v] = depth[u] + 1
            dfs(v, u)
    dfs(root, -1)
    for k in range(1, LOG):
        for v in range(n):
            prev = up[k-1][v]
            up[k][v] = -1 if prev == -1 else up[k-1][prev]
    return up, depth

def lca(u, v, up, depth):
    LOG = len(up)
    if depth[u] < depth[v]: u, v = v, u
    # lift u up
    diff = depth[u] - depth[v]
    for k in range(LOG):
        if diff & (1<<k):
            u = up[k][u]
    if u == v: return u
    for k in range(LOG-1, -1, -1):
        if up[k][u] != up[k][v]:
            u, v = up[k][u], up[k][v]
    return up[0][u]

# --- Morris inorder traversal ---
def morris_inorder(root):
    res = []
    cur = root
    while cur:
        if not cur.left:
            res.append(cur.val)
            cur = cur.right
        else:
            pre = cur.left
            while pre.right and pre.right is not cur:
                pre = pre.right
            if not pre.right:
                pre.right = cur
                cur = cur.left
            else:
                pre.right = None
                res.append(cur.val)
                cur = cur.right
    return res

# --- Greedy: interval scheduling ---
def max_non_overlapping(intervals):
    intervals.sort(key=lambda x: x[1])
    cnt = 0; end = -10**18
    for s,e in intervals:
        if s >= end:
            cnt += 1; end = e
    return cnt

# --- MST: Kruskal ---
def kruskal(n, edges):
    uf = UnionFind(n)
    total = 0
    for u,v,w in sorted(edges, key=lambda e: e[2]):
        if uf.union(u,v):
            total += w
    return total

# --- MST: Prim (adj list) ---
def prim(n, adj):
    seen = [False]*n
    pq = [(0, 0)]
    res = 0; taken = 0
    while pq and taken < n:
        w,u = heapq.heappop(pq)
        if seen[u]: continue
        seen[u] = True; res += w; taken += 1
        for v, wt in adj[u]:
            if not seen[v]:
                heapq.heappush(pq, (wt, v))
    return res if taken == n else None

# --- Backtracking templates ---
def subsets(nums):
    res = []
    cur = []
    def dfs(i):
        if i == len(nums):
            res.append(cur[:]); return
        cur.append(nums[i]); dfs(i+1)
        cur.pop(); dfs(i+1)
    dfs(0)
    return res

def permutations(nums):
    res = []
    def backtrack(i):
        if i == len(nums):
            res.append(nums[:]); return
        for j in range(i, len(nums)):
            nums[i], nums[j] = nums[j], nums[i]
            backtrack(i+1)
            nums[i], nums[j] = nums[j], nums[i]
    backtrack(0)
    return res

# --- 0/1 Knapsack (classic DP) ---
def knapsack_01(weights, values, W):
    n = len(weights)
    dp = [0]*(W+1)
    for i in range(n):
        w, v = weights[i], values[i]
        for cap in range(W, w-1, -1):
            dp[cap] = max(dp[cap], dp[cap-w] + v)
    return dp[W]

# --- LIS O(n log n) ---
def lis_length(a):
    import bisect
    tails = []
    for x in a:
        i = bisect.bisect_left(tails, x)
        if i == len(tails):
            tails.append(x)
        else:
            tails[i] = x
    return len(tails)

# --- Edit Distance ---
def edit_distance(a, b):
    m, n = len(a), len(b)
    dp = [[0]*(n+1) for _ in range(m+1)]
    for i in range(m+1): dp[i][0] = i
    for j in range(n+1): dp[0][j] = j
    for i in range(1, m+1):
        for j in range(1, n+1):
            if a[i-1] == b[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else:
                dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
    return dp[m][n]

# --- Bipartite Check ---
def is_bipartite(n, adj):
    color = [0]*n
    for s in range(n):
        if color[s] != 0: continue
        color[s] = 1
        q = deque([s])
        while q:
            u = q.popleft()
            for v in adj[u]:
                if color[v] == 0:
                    color[v] = -color[u]; q.append(v)
                elif color[v] == color[u]:
                    return False
    return True

# --- Eulerian Path existence (undirected) ---
def has_eulerian_trail_undirected(n, adj):
    # Check 0 or 2 vertices of odd degree and graph is connected (ignoring 0-degree)
    odd = sum(1 for u in range(n) if len(adj[u]) % 2 == 1)
    return odd in (0, 2)

# --- Floyd Cycle Finding (linked list) ---
def detect_cycle(head):
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            return True
    return False

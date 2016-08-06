/*
 There is a fence with n posts, each post can be painted with one of the k colors.
 You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 Return the total number of ways you can paint the fence.
 */

public int numWays(int n, int k) {
int[] dp = {0, k, k*k, 0};
if (n <= 2) {
return dp[n];
}
for (int i = 3; i <= n; i++) {
dp[3] = (k - 1)(dp[1] + dp[2]);
dp[1] = dp[2];
dp[2] = dp[3];
}
return dp[3];
}

public int numWays(int n, int k) {
if (n == 1) return k;
if (n == 0) return 0;
int diff = k*(k-1);
int same = k;
for (int i = 2; i < n; i++) {
temp = diff;
diff = (same + diff)*(k - 1);
same = temp;
}
return diff + same;
}
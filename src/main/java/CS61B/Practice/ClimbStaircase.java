package CS61B.Practice;

public class ClimbStaircase {
    public static void main(String[] args) {
        System.out.println(climbStaircase(10));
    }


    // recursive-repeated calculation
    public static int climbStaircase(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStaircase(n - 1) + climbStaircase(n - 2);
    }


    public static int climbStairs(int n) {
        // Base cases
        if (n == 0) return 0; // No ways to reach step 0 (no steps to climb)
        if (n == 1) return 1; // Only one way to reach the first step (1 step)
        if (n == 2) return 2; // Two ways to reach the second step (1+1 or 2 steps)

        // Initialize the dp array to store the number of ways to reach each step
        int[] dp = new int[n + 1];
        dp[1] = 1; // One way to reach step 1
        dp[2] = 2; // Two ways to reach step 2

        // Compute the number of ways to reach each subsequent step
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Ways to reach step i
        }

        // Return the number of ways to reach step n
        return dp[n];
    }
}

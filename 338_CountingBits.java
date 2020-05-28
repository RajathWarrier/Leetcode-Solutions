/*Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
and return them as an array.*/

// Space Comlexity: O(n)
// Time Complexity: O(n)
//Approach - Dynamic Programming

class Solution {
    public int[] countBits(int num) {
        int n = num + 1;
        int[] dp = new int[n];
        dp[0] = 0;
        if(num == 0)
            return dp;
        dp[1] = 1;
        if(num == 1)
            return dp;
        for(int i=2; i<n; i++) {
            dp[i] = i%2 + dp[i/2]; 
        }
        return dp;
    }
}
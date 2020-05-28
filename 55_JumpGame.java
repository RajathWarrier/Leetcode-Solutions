/*Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.*/
//Space Complexity - O(1)
//Time Complexity - O(n)
//Approach - Starting from the last integer in the array chech if the current integer can be reached from any of the previous integers

class Solution {
    public boolean canJump(int[] nums) {
        boolean result = true;
        int distance = 1;
        for (int i=nums.length-2; i>-1; i--) {
            if (nums[i] < distance) {
                distance++;
                result = false;
            }
            else {
                distance = 1;
                result = true;
            }
        }
        
        return result;
    }
}
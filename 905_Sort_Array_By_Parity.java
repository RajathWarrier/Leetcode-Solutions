/*Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
Approach - Maintain an index, say even_i starting from zero to access even section of array.
           Everytime an even number is encountered in the original array, swap it with element on current 'even_i',
Time Complexity - O(n)
Space Complexity - O(1)
*/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int even_i = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] % 2 == 0) {
                int temp = A[even_i];
                A[even_i++] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }
}
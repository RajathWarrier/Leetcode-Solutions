/*Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.*/

//Time Complexity: O(n)
//Approach: If upper limit of A[i] >= lower limit of B[j] and upper limit of B[j] >= lower limit of A[j] there is an intersection
//          Go to next interval only if the corresponding interval of other list has been spanned entirely
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        if(A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        int a = 0;
        int b = 0;
        
        while(a < A.length && b < B.length) {
            if(A[a][1] >= B[b][0] && B[b][1] >= A[a][0]) {
                int[] dummy = new int[2];
                dummy[0] = Math.max(A[a][0], B[b][0]);
                dummy[1] = Math.min(A[a][1], B[b][1]);
                list.add(dummy);
            }
            if(A[a][1] < B[b][1])
                a++;
            else
                b++;
        }
        
        int[][] inter = new int[list.size()][2];
        for(int i=0; i<inter.length; i++) {
            inter[i] = list.get(i);
        }
        
        return inter;
    }
}
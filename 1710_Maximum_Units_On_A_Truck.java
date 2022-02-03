/*
Idea - Gready Approach
Select boxes with highest number of units every time.
If 2 boxes have same number of units, select the type with more
number of boxes.

Space Complexity - O(n), where n is the number of box types.
Time Compexity - O(n*logn), where m is the number of boxes of a type.
*/

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // [1, 3] [2, 2] [3, 1]
        // [5, 10] [4, 7] [3, 9] [2, 5] 
        int maxUnits = 0;
        PriorityQueue<Integer> orderedBoxes = new PriorityQueue<Integer>((a, b) -> {
            if(boxTypes[a][1] == boxTypes[b][1])
                return boxTypes[b][0] - boxTypes[b][1];
            return boxTypes[b][1] - boxTypes[a][1];
        });
        
        for(int i = 0; i < boxTypes.length; i++) {
            orderedBoxes.add(i);
        }

        while(!orderedBoxes.isEmpty() && truckSize > 0) {
            int i = orderedBoxes.poll();
            if(truckSize >= boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                maxUnits += boxTypes[i][0] * boxTypes[i][1];
            }
            else if(truckSize > 0) {
                maxUnits += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
        }
        
        return maxUnits;
    }
    
}

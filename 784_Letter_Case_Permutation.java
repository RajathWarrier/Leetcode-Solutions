/**Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. You can return the output in any order.
 * Approach - Each character, if a letter, makes a new word, one where it is the lowercase and the other where it is the
 * upper case.
 * Time Complexity - O(2^n)
 * Space Complexity - O(2^n)*/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> allPermutations = new ArrayList<>();   
        permute("", S, allPermutations);
        return allPermutations;
    }
    private void permute(String permutation, String remaining, List<String> allPermutations) {
        if(remaining.length() == 0) {
            allPermutations.add(permutation);
            return;
        }
        if(Character.isDigit(remaining.charAt(0))) {
            permutation += remaining.substring(0, 1);
            permute(permutation, remaining.substring(1, remaining.length()), allPermutations);
        }
        else {
            String permutationL = permutation + remaining.substring(0, 1).toLowerCase();
            String permutationR = permutation + remaining.substring(0, 1).toUpperCase();
            permute(permutationL, remaining.substring(1, remaining.length()), allPermutations);
            permute(permutationR, remaining.substring(1, remaining.length()), allPermutations);
        }
    }
}
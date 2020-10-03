/** Valid Parantheses 
 * Approach - Push all open brackets into stack. The latest pushed bracket should be the first one to close. To check this, whenever
 * we encounter a closing bracket the top of the stack must contain a matching open bracket. If it doesn't, string is not valid.
 */

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> pair = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');
        for(char c: s.toCharArray()) {
            if(c == ')' || c == '}' || c == ']') {
                if(stack.empty() || pair.get(c) != stack.peek())
                    return false;
                stack.pop();
            }
            else
                stack.push(c);
        }
        
        return stack.empty();
    }
}
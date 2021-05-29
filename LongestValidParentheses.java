public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int length = s.length();
        if(length == 0) return 0;

        int count = 0;
        int maxCount = 0;
        char prev = s.charAt(0);
        int current = 1;
        while(current < length){
            if(prev == '(' && s.charAt(current) == ')') {
                if(current + 2 < length){
                    current = current + 1;
                }
                count++;
            }
            else {
                count = 0;
            }

            if(count > maxCount) maxCount = count;
            prev = s.charAt(current);
            current++;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int result = longestValidParentheses("(()");
    }
}
 
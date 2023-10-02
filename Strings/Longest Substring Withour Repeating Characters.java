class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxSubLength = 0;
        for(int right = 0 ; right<s.length() ; right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxSubLength = Math.max(maxSubLength, right-left+1);
            }
            else{
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }
        }
        return maxSubLength;
    }
}

/* Naive approach will be Kadane's algorithm - which generates all the possible substrings of the string and then we can find the longest substring without repeating characters */

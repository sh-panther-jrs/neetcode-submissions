class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        if (s.length()==0) {
            return 0;
        }
        Map<Character, Integer> charToIndex = new HashMap<>();
        int maxLength=1;
        while(end<s.length()){
            if(charToIndex.containsKey(s.charAt(end))
             && charToIndex.get(s.charAt(end))>=start) {
                start = charToIndex.get(s.charAt(end))+1;
            }
            maxLength = Math.max(maxLength, end-start+1);
            charToIndex.put(s.charAt(end), end);
            end++;  
        }
        return maxLength;
    }

}

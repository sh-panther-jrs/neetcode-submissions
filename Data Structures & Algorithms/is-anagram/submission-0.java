class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        Map<Character, Integer> hs = new HashMap<>();
        for(char c:s.toCharArray()) {
            hs.put(c, hs.getOrDefault(c, 0)+1);
        }
        for(char c: t.toCharArray()) {
            if (!hs.containsKey(c)) {
                return false;
            } 
            hs.put(c, hs.get(c)-1);
            if (hs.get(c)==0) {
                hs.remove(c);
            }
        }
        return true;
    }
}

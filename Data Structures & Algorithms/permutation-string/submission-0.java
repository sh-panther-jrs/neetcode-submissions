class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length()) {
            return false;
        }
        HashMap<Character, Integer> hmS1 = buildHashMap(s1, s1.length()-1);
        HashMap<Character, Integer> hmS2 = buildHashMap(s2, s1.length()-1);
        for (int start=0; start<=s2.length()-s1.length(); start++) {
            if(compare(hmS1, hmS2)) {
                return true;
            }
            if (start + s1.length() < s2.length()) {
                int removalCount = hmS2.get(s2.charAt(start));
                if (removalCount==1) {
                    hmS2.remove(s2.charAt(start));
                } else {
                    hmS2.put(s2.charAt(start), hmS2.get(s2.charAt(start))-1);
                }
            
                hmS2.put(s2.charAt(start+s1.length()), hmS2.getOrDefault(s2.charAt(start+s1.length()), 0)+1);
            }
            
        }
        return false;
    }

    private boolean compare(HashMap<Character, Integer> hm1, HashMap<Character, Integer> hm2) {
        if(hm1.size()!=hm2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry: hm1.entrySet()) {
            if (entry.getValue()!=hm2.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> buildHashMap(String s, int index) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int i=0;
        for(char c:s.toCharArray()) {
            if(index<i) {
                break;
            }
            hm.put(c, hm.getOrDefault(c, 0)+1);
            i++;
        }
        return hm;
    }

}

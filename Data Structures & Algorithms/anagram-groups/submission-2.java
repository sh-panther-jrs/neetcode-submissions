class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> output = new HashMap<>();
        for(String s: strs) {
            int count[] = new int[26];
            for (char ch: s.toCharArray()) {
                System.out.println(ch-'a');
                count[ch-'a']++;
            }
            String key = convertToKey(count);
            System.out.println(s + ":" +key);
            output.putIfAbsent(key, new ArrayList<>());
            output.get(key).add(s);
        }
        return new ArrayList<>(output.values());
    }

    private String convertToKey(int count[]) {
        String out = "";
        for(int s:count) {
            out=out+":" +s;
        }
        return out;
    }
}

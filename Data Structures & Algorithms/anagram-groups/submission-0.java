class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> storeStr = new HashMap<>();
        for(String str: strs) {
            String encoded = encodeString(str);
            storeStr.putIfAbsent(encoded, new ArrayList<>());
            storeStr.get(encoded).add(str);
        }
        return new ArrayList<>(storeStr.values());
    }
    private String encodeString(String str) {
        int[] countChar = new int[26];
        for(char c: str.toCharArray()) {
            int charVal = (int) c - (int) 'a';
            countChar[charVal]++;
        }
        return encodeArray(countChar);
    }
    private String encodeArray(int[] countChar) {
        int aInt = (int)'a';
        String output = "";
        for(int countCh:countChar) {
            char currChar = (char) aInt;
            output = output + currChar + countCh + ":";
            aInt++;
        }
        return output;
    }
}

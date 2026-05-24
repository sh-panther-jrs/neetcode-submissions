class Solution {
    public String longestCommonPrefix(String[] strs) {
        String output="";
        int maxLength=getMaxLength(strs);
        int currIndex=0;
        while(currIndex<maxLength){
                char prev=' ';
                for(String str: strs) {
                    if (prev!=' ' || str.length()==currIndex) {
                        if(str.length()==currIndex || prev!=str.charAt(currIndex)) {
                            return output;
                        }
                    } else {
                        prev=str.charAt(currIndex);
                    }
                }
                output=output+prev;
                currIndex++;    
        }
        return output;
    }
    private int getMaxLength(String[] strs) {
        int length=0;
        for (String str:strs) {
            length=Math.max(str.length(), length);
        }
        return length;
    }
}
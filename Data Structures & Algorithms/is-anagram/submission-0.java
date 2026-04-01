class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0;i<n;i++){
            freq[sArray[i]-'a']++;
            freq[tArray[i]-'a']--;
        }
        for(int i =0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}

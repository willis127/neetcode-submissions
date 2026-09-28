class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> letters = new HashMap<Character, Integer>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(letters.containsKey(ch)){
                letters.put(ch, letters.get(ch) + 1);
            }else{
                letters.put(ch, 1);
            }
        }
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            if(letters.containsKey(ch)){
                if(letters.get(ch) > 1){
                    letters.put(ch, letters.get(ch) - 1);
                }else{
                    letters.remove(ch);
                }
            }
        }
        if(letters.isEmpty())
            return true;
        else
            return false;
    }
}

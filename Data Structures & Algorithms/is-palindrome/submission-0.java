class Solution {
    public boolean isPalindrome(String s) {
        List<Character> orderList = new LinkedList<>();
        List<Character> reverseList = new LinkedList<>();
        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                orderList.add(Character.toLowerCase(s.charAt(i)));
            }
            if (Character.isLetterOrDigit(s.charAt(s.length() - 1 - i))){
                reverseList.add(Character.toLowerCase(s.charAt(s.length() -1 - i)));
            }
        }
        
        String orderStr = String.valueOf(orderList);
        String reverseStr = String.valueOf(reverseList);
        return orderStr.equals(reverseStr);
    }
}

class Solution {
    public boolean isValid(String s) {
        Deque<Character> chQueue = new ArrayDeque<>(); 
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                chQueue.add(ch);
            } else {
                if (ch == ')') {
                    if (!chQueue.isEmpty() && chQueue.getLast() == '(') {
                        chQueue.removeLast();    
                    } else {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (!chQueue.isEmpty() && chQueue.getLast() == '[') {
                        chQueue.removeLast();    
                    } else {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (!chQueue.isEmpty() && chQueue.getLast() == '{') {
                        chQueue.removeLast();    
                    } else {
                        return false;
                    }
                }
            }
        }
        if (chQueue.isEmpty())
            return true;
        else
            return false;
    }
}

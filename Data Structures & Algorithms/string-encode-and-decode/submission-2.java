class Solution {
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String str : strs){
            byte[] bytes = str.getBytes();
            if(str.equals("")){
                sb.append("000,");
            }else{
                for(byte bt : bytes){
                    sb.append(Byte.toString(bt)).append(",");
                }
            }
            sb.append("999,");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        String[] encodedStrs = str.split("999,");
        StringBuffer sb = null;
        List<String> decodedStrs = new LinkedList<>();
        for(String encodedStr : encodedStrs){
            if (encodedStr.equals("000,")) {
                decodedStrs.add("");
            }else if(!encodedStr.equals("")){
                sb = new StringBuffer();
                String[] strArr = encodedStr.split(",");
                for(String string : strArr){                
                    sb.append((char) Byte.parseByte(string));
                }
                decodedStrs.add(sb.toString());
            }
        }
        return decodedStrs;
    }
}

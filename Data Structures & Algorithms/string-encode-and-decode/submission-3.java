class Solution {

    public String encode(List<String> strs) {
        StringBuilder value = new StringBuilder();
        for(String str: strs){
            value.append(str.length()).append("#").append(str);
        }
        return value.toString();
    }

    public List<String> decode(String str) {
       List<String> resultStr = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j) != '#'){
                j++;
            }
           int len = Integer.parseInt(str.substring(i,j));
           j++; //skip #
           resultStr.add(str.substring(j, j+len));
           i = j+len;
        }
       return resultStr;
    }
}

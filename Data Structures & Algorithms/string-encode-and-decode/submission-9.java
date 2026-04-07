class Solution {

    public String encode(List<String> strs) {
        int len = strs.size();
        if(len == 0) return "";
        StringBuilder encode = new StringBuilder();
        for(int i=0;i<len;i++){
            encode.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return encode.toString();
    }

    public List<String> decode(String str){
       List<String> decodeList = new ArrayList<>();
        int i = 0;

        while(i<str.length()){
            int j=i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            j++;
            String result = str.substring(j,j+len);
            decodeList.add(result);
            i = j+len;

        }


       return decodeList;
    }
}

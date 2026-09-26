class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int j = 0;
        HashMap<String, String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0), list.get(1));
        }
     

        while(j < n){
            if(s.charAt(j) == '('){
                StringBuilder key = new StringBuilder();
                int i = j+1;
                while(i < n && s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }

                String value = "?";
                // for(List<String> list : knowledge){
                //     if(list.get(0).equals(key.toString())){
                //         value = list.get(1);
                //         break;
                //     }
                // }
                if(map.containsKey(key.toString())){
                    value = map.get(key.toString());
                }

                result.append(value);
                j = i + 1;
            } else{
                result.append(s.charAt(j));
                j++;
            }
        }

        return new String(result);
    }
}
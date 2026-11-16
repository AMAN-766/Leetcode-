class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            int si = 0;
            
            while(si <  s.length()){

                if(si + k < s.length()){
                    int num = DigitSum(s.substring(si,si+k));
                    si = si + k;
                    sb.append(num);

                }else{
                    int num = DigitSum(s.substring(si));
                    sb.append(num);
                    break;
                }

            }

            s = sb.toString();

        }
        return s;

    }
    public int DigitSum(String s){
        int sum = 0;

        for(char ch : s.toCharArray()){
            sum += ch - '0';
        }
        return sum;
    }
}
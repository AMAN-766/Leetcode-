class Solution {
    public boolean checkString(String s) {
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=arr[i]){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>>ans=new ArrayList<>();
        int i=0;
        int n=s1.length();
        while(i<n){
            if(s1.charAt(i)==s2.charAt(i)){
                i++;
                continue;
            }
            int start=i;
            while(i<n && s1.charAt(i)!=s2.charAt(i)){
                i++;
            }
            String sub1=s1.substring(start,i);
            String sub2=s2.substring(start,i);
            List<String>segment=new ArrayList<>();
            segment.add(sub1);
            segment.add(sub2);
            ans.add(segment);
        }
        return ans;
    }
}
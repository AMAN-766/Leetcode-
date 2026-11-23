class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n=rain.length;
        String[]ans=new String[n];
        int alice=0;
        int bob=0;
        for(int i=0;i<n;i++){
            if(rain[i]==1){
                if(i!=n-1 && rain[i+1]==1){
                    if(alice<=bob){
                        ans[i]="Alice";
                        alice++;
                    }else{
                        ans[i]="Bob";
                        bob++;
                    }
                }else{
                    ans[i]="Bob";
                    bob++;
                }
            }else{
                ans[i]="None";
            }
        }
        return ans;
    }
}
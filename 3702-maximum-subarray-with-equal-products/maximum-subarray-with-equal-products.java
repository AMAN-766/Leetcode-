class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int maxlen=0;
        for(int i=0;i<n;i++){
            long gcd=0;
            long lcm=1;
            long pro=1;
            for(int j=i;j<n;j++){
                pro*=nums[j];
                lcm=checklcm(lcm,nums[j]);
                gcd=checkgcd(gcd,nums[j]);
                if(pro==lcm*gcd){
                    maxlen=Math.max(maxlen,j-i+1);
                }
            }
        }
        return maxlen;
    }
    public long checkgcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long checklcm(long a,long b){
        return (a*b)/(checkgcd(a,b));
    }
}
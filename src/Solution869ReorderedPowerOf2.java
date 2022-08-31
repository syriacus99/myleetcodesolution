import java.util.Arrays;

public class Solution869ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        int[] nCount = countDigit(n);
        //compare with every number which is power of 2
        for(int i=0;i<31;i++){
            if(Arrays.equals(nCount,countDigit(1<<i))){
                return true;
            }
        }
        return false;
    }

    // count each digit num in int num
    public int[] countDigit(int num){
        int[] ans = new int[10];
        while(num>0){
            ans[num%10]++;
            num/=10;
        }
        return ans;
    }
}

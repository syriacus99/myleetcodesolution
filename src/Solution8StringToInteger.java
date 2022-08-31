public class Solution8StringToInteger {
    public static int myAtoi(String s) {
        s = s.replace(" ","");
        int n = s.length();
        String res = "";
        boolean ctl = false;
        boolean symbolctl = false;
        for(int i=0;i<n;i++){
            if(symbolctl && (s.charAt(i)=='-'|| s.charAt(i)=='+')){
                break;
            }

            if(res.length()>0){
                if(res.length()>10 && res.charAt(0)!= '-'){
                    return Integer.MAX_VALUE;
                }

                if(res.length()>11 && res.charAt(0) == '-'){
                    return Integer.MAX_VALUE;
                }
            }

            if(s.charAt(i)!='+'&& s.charAt(i)!='-' && (s.charAt(i)<'0' || s.charAt(i)>'9')){
                break;
            }

            if(s.charAt(i)=='-'|| s.charAt(i)=='+'){
                res += s.charAt(i);
                symbolctl = true;
            }
            if(!ctl && s.charAt(i)>'0' && s.charAt(i)<='9'){
                res += s.charAt(i);
                ctl = true;
            }
            else if(ctl && s.charAt(i)>='0' && s.charAt(i)<='9'){
                res += s.charAt(i);
            }
        }
        if(res.equals("")||res.equals("-")||res.equals("+")){return 0;}
        Long resLong = Long.parseLong(res);
        if(resLong>(long)Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(resLong<(long)Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+-12"));

    }
}

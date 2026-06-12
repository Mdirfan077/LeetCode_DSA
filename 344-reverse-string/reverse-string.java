class Solution {
    public void reverseString(char[] s) {
        int sp=0;
        int ep=s.length-1;

        while(sp<ep){
            char temp=s[sp];
            s[sp]=s[ep];
            s[ep]=temp;
            sp++;
            ep--;
        }
    }
}
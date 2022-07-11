package no_5_longest_palindrome;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindromeV2("babad"));
    }
    /*
        法1：动态规划
        设 f(m,n)指 m~n 是否为回文字符串  false or true  m<n
        这样 f(m -1 ,n + 1) = f(m,n) && (s.charAt(m-1)==s.chatAt(n+1))
        这里需要考虑清楚的 是遍历的方式，限制left < right
     */
    public String longestPalindrome(String s) {
        boolean[][] fn = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            fn[i][i] = true;
        }
        int count = 1;
        int[] result = new int[]{0, 0};
        for (int m = 1; m < s.length(); m++) {
            for (int n = 0; n < m; n++) {
                if ((m - n) < 2) {
                    fn[n][m] = s.charAt(n) == s.charAt(m);
                } else {
                    fn[n][m] = fn[n + 1][m - 1] && (s.charAt(m) == s.charAt(n));
                }
                if (fn[n][m]) {
                    if ((m - n + 1) > count) {
                        count = m - n + 1;
                        result = new int[]{n, m};
                    }
                }
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    public static String longestPalindromeV2(String s) {
        int [] result = new int[2];
        for (Integer i = 0; i < 2 * s.length() -1 ; i++) {
            if (i % 2 == 0) {
                doCal(i / 2, i / 2, result, s);
            } else {
                doCal(i / 2, (i / 2) + 1, result, s);
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    public static void doCal(Integer left, Integer right, int [] result , String s) {
        if (left<0 || right > s.length()-1){
            return;
        }
        if (s.charAt(left) == s.charAt(right)) {
            if (right - left > result[1] - result[0]) {
                result[1] = right;
                result[0] = left;
            }
            doCal(left - 1, right + 1, result, s);

        } else {
            return;
        }
    }

}

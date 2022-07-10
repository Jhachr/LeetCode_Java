package no_3_without_repeating;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }


    /*
    一开始就知道是滑动窗口，但是还是没有解出来
    这道题是老大难


    其实这里 只是在移动右侧指针，不断向后遍历，而左侧指针的意义，实际是，在当前右侧指针的字母下，左侧为多少时，才可以不重复。
    因此，这里的指针移动为 right++  ，  left = 在当前右侧指针字母下不重复时的最大值，即Math.max(left , map.get(s.charAt(right) + 1))
    为了不重复 所以这里需要+1
     */
    public static  int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int right = 0;  // 定义了左闭右闭的区间
        Map <Character , Integer > map = new HashMap<>();

        while (right < s.length()){
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left , map.get(s.charAt(right) + 1));
            }
            map.put(s.charAt(right), right);
            result = Math.max(result , right - left + 1);
            right++;
        }
        return result;
    }

}

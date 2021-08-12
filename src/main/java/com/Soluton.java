package com;

import java.util.HashMap;
import java.util.Map;


public class Soluton {



    public int reverse(int x){
        int i=0;
        int tmp;
        int t=214748364;
        while (x!=0){
            if (i>t|i<-t){
                return 0;
            }
            tmp=x%10;
            x/=10;
            i=i*10+tmp;
        }
        return i;
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t=target-nums[i];
            if (map.containsKey(t)){
                return new int[]{map.get(t),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        int i=0;
        int j=0;
        if (len%2==0){
            while (true){
                if (nums1[i]<nums2[j]&i<nums1.length){
                    i++;
                    if (i+j==len/2){
                        if (nums1[i]<nums2[j]){
                            return (nums1[i]+nums2[j])/2;
                        }else {
                            return (nums1[i]+nums2[j+1])/2;
                        }
                    }
                }else if (j<nums2.length){
                    j++;
                    if (i+j==len/2){
                        if (nums1[i]<nums2[j]){
                            return (nums1[i]+nums2[j])/2;
                        }else {
                            return (nums1[i]+nums2[j+1])/2;
                        }
                    }
                }

            }
        }else {
            while (true){
                if (nums1[i]<nums2[j]&i<nums1.length){
                    i++;
                    if (i+j==len/2){
                        if (nums1[i]<nums2[j]){
                            return nums1[i];
                        }else {
                            return nums2[j];
                        }
                    }
                }else if (j<nums2.length){
                    j++;
                    if (i+j==len/2){
                        if (nums1[i]<nums2[j]){
                            return nums1[i];
                        }else {
                            return nums2[j];
                        }
                    }
                }

            }
        }
    }
    public boolean isPalindrome(int x) {
        if(x>0&x%10!=0){
            int i=0;
            while (x>i){
                i=i*10+x%10;
                x/=10;
            }
            return x==i|x==i/10;
        }else {
            return false;
        }

    }
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) {
            return head;
        }
        while (head!=null){
            if (head.val!=val) {
                break;
            }
            head=head.next;
        }
        if (head==null) {
            return head;
        }
        ListNode result=head;
        ListNode listNode;
        listNode=head;
        head=head.next;
        while (head!=null){
            if (head.val==val) {
                listNode.next=head.next;
                head=head.next;
            }else {
                listNode=head;
                head=head.next;
            }
        }
        return result;

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

    private static int count=0;


    public int findTargetSumWays(int[] nums, int target) {
        c(0,0,nums,target);
        return count;

    }
    public void c(int sum,int i,int[] nums,int target){
        if (i==nums.length){
            if (sum==target)
                count++;
        }else {
            c(sum+nums[i],i+1,nums,target);
            c(sum-nums[i],i+1,nums,target);
        }
    }



}

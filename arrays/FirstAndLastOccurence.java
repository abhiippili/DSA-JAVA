package com.dsapractice;

import java.util.Arrays;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int arr[] = {1,3,5,5,7,7,7,7,7,8,8,9,10,11,11};
        int target = 7;
        int ans[] = {-1,-1};
        ans[0] = searchOccurence(arr,target,true);
        ans[1] = searchOccurence(arr,target,false);
        System.out.println(Arrays.toString(ans));
    }
    public static int searchOccurence(int arr[], int target, boolean isFirst){
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid]){
                ans = mid;
                if(isFirst)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if(target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return ans;
    }
}

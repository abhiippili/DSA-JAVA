package com.dsapractice;

public class FindPeakInMountain {
    public static void main(String[] args) {
        int arr[] = {0,5,2,3};
        System.out.println(findPeak(arr));
    }
    public static int findPeak(int arr[]){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid + 1])
                start = mid + 1;
            else if (arr[mid] > arr[mid + 1])
                end = mid;
        }
        return start;
//        can return start/end as the peak is found when start == end
//        returning mid can be ans - 1 or ans depending on last movement
    }
}


/*Some Description :
    1. The peak can be considered as part of inc (s=m) or dec (e=m)
       If considered as inc, the checks are :
           arr[mid] > arr[mid-1] start = mid
           arr[mid] < arr[mid-1] end = mid + 1
    Fact: Whenever the mid is computed on start and the case is sm,e - infinte loop
          In the case of end getting onto start, will prevent TLE.
    Point To Remember: Never ever make a move start = mid
    Point To Remember: Always make one +ve and another -ve comparision, inorder to reduce the search space.
* */
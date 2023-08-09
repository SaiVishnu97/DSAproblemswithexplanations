The Solution goes in this manner

At first for every element you will find out its next immediate smallest element to the right and the next immediate smallest element to the left.Store the results in the left and the right arrays respectively


So for the example when the Inputs are
N = 7
arr[] = {10,20,30,50,10,70,30}
 You will Left array as 
 left[]={-1,0,1,2,-1,4,4} and Rigth array as
 right[]={7,4,4,4,7,6,7}

Calculate length[i]=right[i]-left[i]-1 for all the i,
 So for the element 10 the longest subarray where it is the smallest is 7
 similarly for 20 it is 3 and for all the elements length[] looks like the below
   arr[] = {10,20,30,50,10,70,30}
length[] = {7,  3, 2, 1, 7, 1, 2 }

Now since we need to find out the Maximum of mininums of every window size, in the final ans[] array the indices represent length[i]-1 contains the maximum value of arr[i] when both lengths are same

For eg:-
ans[0]=Max(50,70) which is 70 here and how we get is
ans[length[i]-1]=Max(ans[length[i]-1],arr[i]) for all the i;

so we get ans[]={70,30,20,0,0,0,10};

now we if we take minimum subarray say the length i->j the min(arr(i,j)) <= min(arr(i,j-1));

Also, max_of_allsubarraysoflength_i->j(min(arr(i,j))) <= max_of_allsubarraysoflength_i->j-1(min(arr(i,j-1)))

therefore  with  
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
         we get ans={70,30,20,10,10,10,10};
        which means if 10 is the maximum element of all subarrays of length 7 then chances are that it might be the maximum element of all subarrays of length 6 unless there is an element > 10 .If that is present it would have been caught in the previous calculation of ans[] array.
        Now return the ans[] array..It is the final answer.
    
class Solution {
    public int[] mergeSort(int[] arr,int i, int j){
        if(i == j){
            int[] a = {arr[i]};
            return a;
        }
        
        int mid = (i + j) / 2;
        
        int[] a = mergeSort(arr,i,mid);
        int[] b = mergeSort(arr,mid+1,j);
        
        return mergeTwoSortedArrays(a,b);
    }
    
    public int[] mergeTwoSortedArrays(int[] arr1,int[] arr2){
        int[] arr = new int[arr1.length + arr2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                arr[k++] = arr[k] = arr1[i];
                k++;
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                arr[k] = arr1[i];
                k++;
                i++;
            }else{
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
        
        while(i < arr1.length){
            arr[k] = arr1[i];
            k++;
            i++;
        }
        
        while(j < arr2.length){
            arr[k] = arr2[j];
            j++;
            k++;
        }
        
        return arr;
    }
    public int[] sortArray(int[] arr) {
        return mergeSort(arr,0,arr.length - 1);
    }
}
public class mergeSort{
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int arr[], int si, int ei){
        // base case
        if(si>=ei){
            return;
        }

        //find mid
        int mid = si + (ei-si)/2;
        // left half pe mergesort lagao
        mergeSort(arr, si, mid);
        // right half pe mergeSort lagao
        mergeSort(arr, mid+1, ei);
        // now MERGE left half and right half
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei){
        // LH(0,3), RH(4,6) length ==> 0-3=4 + 4-6=3  length =7  ie 6-0+1
        int temp[] = new int[ei-si+1];
        int i = si; // iterator for LH
        int j = mid+1; //iterator for RH
        int k = 0; // iterator for temp
        while(i<=mid && j<=ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++; k++;

            }
            else{
                temp[k] = arr[j];
                j++; k++;
            }
        }
        //if maanlo i not finished but j finished
        while(i<=mid){
            temp[k] = arr[i];
            k++; i++;
        }
        // if i finished but j still left
        while(j <= ei){
            temp[k] = arr[j];
            k++; j++;
        }
        // copy temp arr to original
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
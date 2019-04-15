package design.model;

public class InsertionSort implements Sort {

   public int[] sort(int arr[]) {

      int len = arr.length;
      for(int i=1; i<len; i++) {
         int v = arr[i];
         int j = i-1;
         while (j>=0 && arr[j]>v) {
            arr[j+1] = arr[j];
            j--;
            arr[j-1] = v;
         }
      }
      return null;
   }

}
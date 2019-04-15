package design.model;

public class SelectionSort implements Sort {

   public int[] sort(int arr[]) {

      int len = arr.length;
      for(int i=0; i<len-1; i++) {
         int vmin = 0;
         int min = arr[i];
         for(int j=i+1; j<len; j++) {
            if(min > arr[j]) {
               vmin = j;
               min = arr[j];
            }
         }
         int temp = arr[i];
         arr[i] = arr[vmin];
         arr[vmin]  = temp;
      }
      return arr;
   }
}
public class QuickSort_2 {

    public static void main(String[] args) {
        int[] array = {5, 0, 10, 8, 7, 12, 9, 12, 15};
        quickSort(array, 0, array.length-1);

        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    public static void quickSort(int[] array, int left, int right) {

        if(left < right) {
            int s = partition(array, left, right);
            quickSort(array, left, s-1);
            quickSort(array, s+1, right);
        }
    }

    public static int partition(int[] array, int left, int right) {

        int p = array[left];
        int i = left+1, j = right;

        while(i < j) {
            //哨兵j 从后往前 先出发
            while(array[j]>p){
                j--;
            }
            while(array[i]<p){
                i++;
            }
            swap(array, i, j);
        }
        swap(array, i, j);
        swap(array, left, j);
        return j;
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

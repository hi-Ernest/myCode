package base.algorithm;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {4, 1, 10, 8, 7, 12, 9, 2, 15};
        new QuickSort().sort(array, 0, array.length-1);

        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    void sort(int array[], int left, int right) {
        if (left <right) {
            int index = partition(array, left, right);
            sort(array, left, index-1);
            sort(array, index, right);
        }

    }

    public int partition(int[] array, int left, int right) {
        if(array==null || array.length<=0 || left<0 || right>=array.length){
            return 0;
        }
        int prio = array[left + (right - left) / 2];
        while(left<=right){
            while (array[left] < prio)
                left++;
            while (array[right] > prio)
                right--;
            if (left<=right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

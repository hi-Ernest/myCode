package base.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {89,45,68,90,29,34,17};
        System.out.println(binarySearch(array, 68));
        System.out.println(binarySearch_2(array, 0, array.length, 68));


    }

    /**
     * 非递归
     * @param array
     * @param k
     * @return
     */
    private static int binarySearch(int[] array, int k) {
        int l = 0;
        int r = array.length-1;

        while (l<=r) {
            int m = (l+r)/2;
            if(k == array[m])
                return m;
            else if(k < array[m])
                r = m-1;
            else
                l = m+1;
        }
        return -1;
    }

    /**
     * 递归
     * @param array
     * @param low
     * @param hight
     * @param k
     * @return
     */
    private static int binarySearch_2(int[] array,int low, int hight, int k) {
        int mid;
        if(low > hight)
            return -1;
        else {
            mid = (low + hight)/2;
            if(k == array[mid])
                return mid;
            if(k > array[mid])
                return binarySearch_2(array, mid+1, hight, k);
            else
                return binarySearch_2(array, low, mid-1, k);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // HeapSort heapSort = new HeapSort();
        // int arr[]={2,4,5,1,1,0,2,4,6};
        // heapSort.heapSort(arr, arr.length-1);
        // for (int i : arr) {
        //     System.out.println(i+" ");
        // }
        // HeapSort heapSort = new HeapSort();
        QuickSort quickSort = new QuickSort();
        int arr1[]={2,4,5,1,1,0,2,4,6};
        quickSort.quickSort(arr1,0, arr1.length-1);
        for (int i : arr1) {
            System.out.println(i+" ");
        }
    }
}

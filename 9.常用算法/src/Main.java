public class Main {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int arr[]={2,4,5,1,1,0,2,4,6};
        heapSort.heapSort(arr, arr.length-1);
        for (int i : arr) {
            System.out.println(i+" ");
        }
    }
}

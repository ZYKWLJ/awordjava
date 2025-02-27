public class HeapSort {
    // 自上往下构建0~截止位置
    public void heapAdjust(int[] arr, int start, int end) {
        for (int i = start * 2 + 1; i <= end; i = 2 * i + 1) {

            if (i <= end-1 && arr[i] < arr[i + 1]) {// 比较左右节点的较大值
                i++;
            }
            if (arr[start] < arr[i]) {// 父节点与左右节点较大值交换
                swap(arr, start, i);
                start = i;
            } else {
                break;
            }
        }
    }

    void heapSort(int arr[], int length) {// 传入的是索引
        // 第一次构建大根堆(最后一个飞叶子节点)
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, length);
        }
        // 每次进行首尾交换，再次构建堆
        for (int i = 0; i <= length; i++) {
            swap(arr, 0, length - i);
            heapAdjust(arr, 0, length - i-1); // 进行调整，每次都少构建一个索引
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
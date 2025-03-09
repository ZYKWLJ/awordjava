package v1;

public class OperationAdapter implements ScoreOperation {//实现类是客户端使用的接口
    // 这两个属性是适配的接口
    // 通过这个类就将适配的两个类连接起来了！
    private QuickSort sortObj;
    private BinarySearch binarySearch;

    
    public OperationAdapter(QuickSort sortObj, BinarySearch binarySearch) {
        this.sortObj = sortObj;
        this.binarySearch = binarySearch;
    }

    public OperationAdapter() {
    }


    @Override
    public int[] sort(int[] array) {
        return this.sortObj.sort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return this.binarySearch.search(array,key);
    }


    public QuickSort getSortObj() {
        return sortObj;
    }


    public void setSortObj(QuickSort sortObj) {
        this.sortObj = sortObj;
    }


    public BinarySearch getBinarySearch() {
        return binarySearch;
    }


    public OperationAdapter(QuickSort sortObj) {
        this.sortObj = sortObj;
    }


    public OperationAdapter(BinarySearch binarySearch) {
        this.binarySearch = binarySearch;
    }


    public void setBinarySearch(BinarySearch binarySearch) {
        this.binarySearch = binarySearch;
    }
}

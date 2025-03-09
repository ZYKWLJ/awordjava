package v1;

public class OperationAdapter implements ScoreOperation {
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

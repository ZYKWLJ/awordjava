package v1;

public class BinarySearch {
    private QuickSort sortObj;
    
    public BinarySearch(QuickSort sortObj) {
        this.sortObj = sortObj;
    }
    public int search(int[] array,int key){
        this.sortObj.sort(array);
        int r=array.length-1;
        int l=0;
        while (l<=r) {
            int mid=l+(r-l)/2;
            if(array[mid]>key){
                r=mid-1;
            }else if(array[mid]<key){
                l=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

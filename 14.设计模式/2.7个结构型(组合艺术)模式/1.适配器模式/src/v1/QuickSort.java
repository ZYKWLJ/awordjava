package v1;

public class QuickSort {
    public int[] sort(int[] array){
        sortHelper(array, 0, array.length-1);
        return array;
    }
    public void sortHelper(int[] array,int l,int r) {
        if(l>=r)return ;
        int i=l-1,j=r+1;
        int mid = array[l+r>>1];
        while (i < j) {
            while (array[++i] < mid)
                ;
            while (array[--j] > mid)
                ;
            if (i < j)
                swap(array, i, j);
        }
        sortHelper(array,l,j);
        sortHelper(array,j+1,r);
    }

    private void swap(int[] array, int l, int r) {
        int temp=array[l];
        array[l]=array[r];
        array[r]=temp;
    }

}

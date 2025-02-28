public class QuickSort {
    public void quickSort(int[] arr,int l,int r){
        if(l>=r)return;
        int i=l-1,j=r+1,x=arr[l+r>>1];
        while (i<j) {//确保小于某个数的在左边，大于的在右边，全部完成了就排好序了！
            while(arr[++i]<x);
            while(arr[--j]>x);
            if(i<j)swap(arr,i,j);
        }
        quickSort(arr, l, j);
        quickSort(arr, j+1, r);
    }

    public void swap(int[] arr,int i,int j){
        int k=arr[i];
        arr[i]=arr[j];
        arr[j]=k;
    }
}

import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    for(int outer = 0; outer < list.length - 1; outer++){
      for(int inner = 0; inner < list.length - 1 - outer; inner++){
        if(list[inner] > list[inner+1]){
          int temp = list[inner];
          list[inner] = list[inner+1];
          list[inner+1] = temp;
        }
      }
    }    
  }
  public void selectionSort(int[] list)
  {
    int flag;
    int temp;
    for(int outer = 0; outer < list.length - 1; outer++){
      flag = outer;
      for(int inner = flag + 1; inner < list.length; inner++){
        if(list[inner] < list[flag])
          flag = inner;
      }
      temp = list[outer];
      list[outer] = list[flag];
      list[flag] = temp;
    }
  }

  public void insertionSort(int[] list)
  {
    for(int outer = 1; outer < list.length; outer++){
      int position = outer;
      int key = list[position];
      while(position > 0 && list[position - 1] > key){
        list[position] = list[position - 1];
        position--;
      }
      list[position] = key;
     }
  }

  private void merge(int[] a, int first, int mid, int last)
  {
    int i = first;
    int j = mid + 1;
    int k = first;
    int [] temp = new int[a.length];
    while (i <= mid && j <= last)
    {
      if (a[i] < a[j]){
        temp[k] = a[i];
        i++;
      }
      else{
        temp[k] = a[j];
        j++;
      }
      k++;
    }
    while (i <= mid){
      temp[k] = a[i];
      i++;
      k++;
    }
    while (j <= last){
      temp[k] = a[j];
      j++;
      k++;
    }
    for (k = first; k <= last; k++){
      a[k] = temp[k];
    }
  }

  public void mergeSort(int[] a, int first, int last)
  {
    int center = (first + last) / 2;
    if( first < last )
    {
      mergeSort(a, first, center);
      mergeSort(a, center + 1, last);
    }
    merge(a, first, center, last);
  }
}


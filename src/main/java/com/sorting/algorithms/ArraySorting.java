package com.sorting.algorithms;

import java.util.ArrayList;

public class ArraySorting {

    public ArrayList<ArrayList<Integer>> selectionSort(int[] array){
        ArrayList<ArrayList<Integer> > aList = new ArrayList<>();
        ArrayList<Integer> arrayList;
        int[] tempArray = array.clone();
        int temp = 0;
        for(int i=0; i<tempArray.length; i++){
            for(int j = i; j<tempArray.length; j++){
                arrayList = new ArrayList<>();
                if(tempArray[i]>tempArray[j]){
                    temp = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = temp;
                    for (int m : tempArray)
                    {
                        arrayList.add(m);
                    }
                    aList.add(arrayList);
                }
            }
        }
        return aList;

    }

    public ArrayList<ArrayList<Integer>> bubbleSort(int[] array){
        ArrayList<ArrayList<Integer> > aList = new ArrayList<>();
        ArrayList<Integer> arrayList;
        int [] tempArray = array.clone();
        int temp = 0;
        for(int i = 0; i < tempArray.length - 1; i++){
            for(int j = 0; j<tempArray.length - i - 1; j++){
                arrayList = new ArrayList<>();
                if(tempArray[j]>tempArray[j+1]){
                    temp = tempArray[j];
                    tempArray[j] = tempArray[j+1];
                    tempArray[j+1] = temp;
                    for (int m : tempArray)
                    {
                        arrayList.add(m);
                    }
                    aList.add(arrayList);
                }
            }
        }
        return aList;
    }


    public ArrayList<ArrayList<Integer>> insertionSort(int[] array){
        ArrayList<ArrayList<Integer> > aList = new ArrayList<>();
        ArrayList<Integer> arrayList;
        int [] tempArray = array.clone();
        int key = 0;
        int j = 0;
        for(int i = 1; i<tempArray.length; ++i){
            arrayList = new ArrayList<>();
            key = tempArray[i];
            j = i -1;
            while (j>=0 && tempArray[j]>key) {
                tempArray[j+1] = tempArray[j];
                j --;
            }
            tempArray[j + 1] = key;
            for (int m : tempArray)
            {
                arrayList.add(m);
            }
            aList.add(arrayList);
        }
        return aList;
    }


    // public static void main(String[] args) {
    //     int [] array = {23,43,12,5,47,456,234,1,5,0};


    //         System.out.println(selectionSort(array));
        
    // }
}

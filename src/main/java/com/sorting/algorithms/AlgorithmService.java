package com.sorting.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;


@Service
public class AlgorithmService {
    ArraySorting arraySorting = new ArraySorting();
    private int[] array;
    private ArrayList<ArrayList<Integer>>sortedArray;

    public int[] getArray() {
        return array;
    }


    public boolean checkValidArray(String string){
        System.out.println(string);
        String [] arrayOfString = string.split("[,]");
        System.out.println(arrayOfString);
        int [] array = {};
        try{
            array =  Arrays.stream(arrayOfString)
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }
        catch(NumberFormatException numberFormatException){
            return false;
        }
        catch(Exception exception){
            return false;
        }

        System.out.println(array);
        if(array.length<2){
            return false;
        }

        this.array = array;
        return true;
    }


    public ArrayList<ArrayList<Integer>> selectionSort(int[] unSortedArray) {
        this.sortedArray = this.arraySorting.selectionSort(unSortedArray);
        return this.sortedArray;
    }


    public ArrayList<ArrayList<Integer>> bubbleSort(int[] unSortedArray) {
        this.sortedArray = this.arraySorting.bubbleSort(unSortedArray);
        return this.sortedArray;

    }


    public ArrayList<ArrayList<Integer>> insertionSort(int[] unSortedArray) {
        this.sortedArray = this.arraySorting.insertionSort(unSortedArray);
        return this.sortedArray;
    }
}

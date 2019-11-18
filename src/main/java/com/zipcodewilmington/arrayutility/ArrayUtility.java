package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;
    public ArrayUtility(T[] array ){
        this.array = array;
    }
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] arrayNew = mergeArray(arrayToMerge);
        Integer index = array.length;
        for (T t : arrayToMerge) {
            arrayNew[index] = t;
            index++;
        }
        return countOccurrences(arrayNew, valueToEvaluate);
    }

    private T[] mergeArray(T[] arrayToMerge){
        return Arrays.copyOf(array, array.length + arrayToMerge.length);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Set<T> tSet = new HashSet<>(Arrays.asList(mergeArray(arrayToMerge)));
        Integer mostNum = 0;
        T value = null;
        for(T x : tSet){
            Integer count = countOccurrences(array,x);
            if(count > mostNum) {
                mostNum = count;
                value = x;
            }
        }
        return value;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return countOccurrences(array, valueToEvaluate);
    }

    private Integer countOccurrences(T[] array, T valueToEvaluate){
        Integer counter = 0;
        for(int i = 0; i< array.length; i++){
            if(array[i].equals(valueToEvaluate)){
                counter++;
            }
        }
        return counter;
    }

    public T[] removeValue(T valueToRemove) {
        T[] arrayNew = Arrays.copyOf(array, array.length - countOccurrences(array, valueToRemove));
        Integer index = 0;
        for(T x : array){
            if (!x.equals(valueToRemove)){
                arrayNew[index] = x;
                index++;
            }
        }
        return arrayNew;

    }
}

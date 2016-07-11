/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap32.examples.listing32_13;

/**
 *
 * @author Prithpal Sooriya
 */

/*Code taken from Daniel Liang listing 25.5*/
/*How merge sort works:
-->recursive algorith, when a list is constantly split until single units
-->for each recursive step, the 2 halves given are then merged with merge method
-->when merge() called, it merges the split list and returns it to the output list
*/
public class MergeSort {

    /**
     * The method for sorting the numbers
     */
    //merge sort will will keep keep dividing till the list is of size 1
    //once the list is of size 1, then it counts as sorted
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);
            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * Merge two sorted lists
     */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        //adds the smaller numbers of the 2 sorted lists into temp (so up to the smaller index)
        while (current1 < list1.length && current2 < list2.length) {
            //compare list1 index with list2 index, and smaller one is placed into temp index
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        //add the rest of list1 (if list1 is larger)
        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        //add the rest of list2 (if list2 is larger)
        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }
}

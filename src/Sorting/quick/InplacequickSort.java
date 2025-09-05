package Sorting.quick;


//logic
//QuickSort(arr, low, high)
//
//If low < high then
//
//Call pi = Partition(arr, low, high)
// Partition the array around a pivot and get pivot index pi
//
//Recursively sort left sub-array:
//QuickSort(arr, low, pi - 1)
//
//Recursively sort right sub-array:
//QuickSort(arr, pi + 1, high)

//Partition(arr, low, high)
//
//Choose the pivot as the last element: pivot = arr[high]
//
//Initialize i = low - 1
//
//For j = low to high - 1 do:
//
//If arr[j] <= pivot then
//
//Increment i by 1
//
//Swap arr[i] and arr[j]
//
//After the loop, swap the pivot element arr[high] with the element at arr[i + 1]
//
//Return the pivot index i + 1

public class InplacequickSort {

//    Initializes an integer array arr.
//
//    Calls the quickSort method on the entire array (0 to arr.length - 1).
//
//    Prints the sorted array.

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

//    Parameters: The array arr, the starting index low, and ending index high.
//
//    Base condition: If low < high, proceed; otherwise, the array or sub-array has one or zero elements (already sorted).
//
//    Calls partition to:
//
//    Choose a pivot element.
//
//    Rearrange the array so that elements less than or equal to the pivot are on the left, and greater elements on the right.
//
//    Returns the index pi where the pivot is placed.
//
//    Recursively applies quickSort to the sub-arrays to the left and right of the pivot.


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

//    Chooses the last element (arr[high]) as the pivot.
//
//    Initializes i as one position before low.
//
//    Iterates through the array from low to high - 1 using j.
//
//    If arr[j] is less than or equal to the pivot, increment i and swap arr[i] with arr[j].
//
//    This ensures all elements up to i are less than or equal to the pivot.
//
//    After the loop, swaps the pivot (arr[high]) with the element right after the last smaller element (arr[i+1]).
//
//    Returns the index i+1 where the pivot is now correctly placed.

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

//Pseudocode for QuickSort

/*
FUNCTION QuickSort(arr, low, high)
    IF low < high THEN
        pi = Partition(arr, low, high)
        QuickSort(arr, low, pi - 1)
        QuickSort(arr, pi + 1, high)
    END IF
END FUNCTION


FUNCTION Partition(arr, low, high)
    pivot = arr[high]
    i = low - 1

    FOR j = low TO high - 1 DO
        IF arr[j] <= pivot THEN
            i = i + 1
            SWAP arr[i] WITH arr[j]
        END IF
    END FOR

    SWAP arr[i + 1] WITH arr[high]
    RETURN i + 1
END FUNCTION

QuickSort recursively sorts the array by dividing it around a pivot.

Partition rearranges elements so that elements ≤ pivot come before it, and elements > pivot come after.

The recursion stops when the sub-array size is 1 or 0 (low >= high).
* */
package Sorting.quick;
import java.util.Scanner;

/*
Algorithm (Step by Step)

QuickSort Function

Input: array arr, starting index low, ending index high.

If low < high:

Call Partition to rearrange the array and get pivot index pi.

Recursively call QuickSort on the left part (low → pi-1).

Recursively call QuickSort on the right part (pi+1 → high).

Partition Function

Choose the last element as pivot (arr[high]).

Initialize i = low - 1.

Loop j from low to high - 1:

If arr[j] <= pivot:

Increase i.

Swap arr[i] with arr[j].

After loop ends:

Swap arr[i+1] with arr[high] (pivot).

Return i+1 (pivot index).

* FUNCTION QuickSort(arr, low, high)
    IF low < high THEN
        pi = Partition(arr, low, high)   // pivot index
        QuickSort(arr, low, pi - 1)      // left part
        QuickSort(arr, pi + 1, high)     // right part
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

    SWAP arr[i+1] WITH arr[high]
    RETURN i + 1
END FUNCTION
*/

public class InplacequickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take the whole line of input
        System.out.println("Enter array elements (space-separated):");
        String line = sc.nextLine();

        // Split by whitespace and convert to int[]
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // Perform quicksort
        quickSort(arr, 0, arr.length - 1);

        // Print sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
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


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchSortApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please kindly enter a list of numbers separated by spaces:");
        String input = scanner.nextLine();
        int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Please choose an option:");
        System.out.println("1. Search for a number");
        System.out.println("2. Sort the list");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Please kindly enter the number to search for:");
                int searchValue = scanner.nextInt();
                long startTime = System.nanoTime();
                int index = linearSearch(numbers, searchValue);
                long endTime = System.nanoTime();
                long runningTime = endTime - startTime;
                System.out.println("The Time Complexity: O(n)");
                System.out.println("The Running time is: " + runningTime + " nanoseconds");
                if (index != -1) {
                    System.out.println("Number found at index " + index);
                } else {
                    System.out.println("Number not found");
                }
                break;
            case 2:
                System.out.println("Please Choose a sorting algorithm:");
                System.out.println("1. Bubble Sort");
                System.out.println("2. Quick Sort");
                int sortChoice = scanner.nextInt();
                if (sortChoice == 1) {
                    startTime = System.nanoTime();
                    bubbleSort(numbers);
                    endTime = System.nanoTime();
                    runningTime = endTime - startTime;
                    System.out.println("The Time Complexity: O(n^2)");
                    System.out.println("Running time: " + runningTime + " nanoseconds");
                } else if (sortChoice == 2) {
                    startTime = System.nanoTime();
                    quickSort(numbers, 0, numbers.length - 1);
                    endTime = System.nanoTime();
                    runningTime = endTime - startTime;
                    System.out.println("The Time Complexity: O(n log n)");
                    System.out.println("Running time: " + runningTime + " nanoseconds");
                }
                System.out.println("Sorted list: " + Arrays.stream(numbers).boxed().collect(Collectors.toList()));
                break;
            default:
                System.out.println("Invalid choice try again");
        }

        scanner.close();
    }

    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
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

import java.util.Scanner;

public class HeapSort {
    public HeapSort() {
    }

    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[i]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void create(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; --i) {
            heapify(arr, i, n);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        create(arr);

        for (int i = n - 1; i > 0; --i) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("Max element: " + arr[arr.length - 1]);
        System.out.println("Min element: " + arr[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Operations: 1. Create Heap 2. Heap Sort  3. Print 4. Exit");
        System.out.println("Enter your choice: ");

        for (int choice = sc.nextInt(); choice != 4; choice = sc.nextInt()) {
            switch (choice) {
                case 1:
                    create(arr);
                    System.out.println("Heap created");
                    break;
                case 2:
                    heapSort(arr);
                    System.out.println("Sorted");
                    break;
                case 3:
                    print(arr);
                    break;
                default:
                    System.out.println("Enter the correct choice");
            }

            System.out.println("Enter your choice: ");
        }

        sc.close();
    }
}

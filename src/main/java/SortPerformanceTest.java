import java.util.Random;

public class SortPerformanceTest {
    public static void main(String[] args) {
        int[] sizes = {30, 100_000};
        SortStrategy[] strategies = {
                new BubbleSort(), new MergeSort(), new QuickSort()
        };
        String[] strategyNames = {
                "Bubble Sort", "Merge Sort", "Quick Sort"
        };

        for (int size : sizes) {
            System.out.println("\nData Size: " + size);
            int[] original = generateRandomArray(size);

            for (int i = 0; i < strategies.length; i++) {
                int[] data = original.clone();
                Sorter sorter = new Sorter();
                sorter.setStrategy(strategies[i]);

                long start = System.nanoTime();
                sorter.sort(data);
                long end = System.nanoTime();

                System.out.printf("%s took %.3f ms%n",
                        strategyNames[i], (end - start) / 1_000_000.0);
            }
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1_000_000);
        }
        return array;
    }
}

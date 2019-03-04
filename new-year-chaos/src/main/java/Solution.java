import java.util.Scanner;

public class Solution {
    static int initialState[] = null;
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int countBribes = 0;
        boolean isSorted = false;
        for(int i = 0; i < q.length; i++){
            if(q[i] - i > 3){
                System.out.println("Too chaotic");
                return;
            }
        }

        while(!isSorted){
            isSorted = true;
            int lastIndexSort = q.length -1;
            for(int i = 0; i <  lastIndexSort; i++){
                if(q[i] > q[i+1]){
                    swap(q, i, i+1);
                    isSorted = false;
                    countBribes++;
                }
            }
            lastIndexSort --;
        }
        System.out.println(countBribes);
    }

    static void swap(int arr[], int index, int nextIndex ){
        int aux = arr[index];
        arr[index] = arr[nextIndex];
        arr[nextIndex] = aux;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//TODO segment tree max + sum
public class BookMyShow {
    long totalNumberOfSeats;

    int numberOfRows;
    int[] lastOccupiedSeat;
    int numberOfSeats;
    int lastFilledRow = - 1;
    boolean soldOut = false;

    public BookMyShow(int n, int m) {
        numberOfRows = n;
        lastOccupiedSeat = new int[n];
        Arrays.fill(lastOccupiedSeat, -1);
        numberOfSeats = m;
        totalNumberOfSeats = (long) m * n;
    }

    public int[] gather(int k, int maxRow) {
        if (k > numberOfSeats) {
            return new int[]{};
        }
        int[] book = {-1, -1};
        for (int i = lastFilledRow + 1; i < numberOfRows && i <= maxRow; i++) {
            if (lastOccupiedSeat[i] + k < numberOfSeats) {
                book[0] = i;
                book[1] = lastOccupiedSeat[i] + 1;
                lastOccupiedSeat[i] += k;

                break;
            }
        }
        if (book[0] == -1) {
            return new int[]{};
        }
        totalNumberOfSeats -= k;
        return book;
    }

    public boolean scatter(int k, int maxRow) {
        if(totalNumberOfSeats < k){
            return false;
        }
        //System.out.println(Arrays.toString(lastOccupiedSeat));
        int temp = k;
        boolean possible = false;
        for (int i = lastFilledRow + 1; i < numberOfRows && i <= maxRow; i++) {

            temp -= numberOfSeats - lastOccupiedSeat[i] - 1;
            if (temp <= 0) {
                possible = true;
                break;
            }
        }
        if (!possible) {
            return false;
        }
        for (int i = lastFilledRow + 1; i <= maxRow && i < numberOfRows; i++) {

            if (k - (numberOfSeats - lastOccupiedSeat[i] - 1) > 0) {
                k -= numberOfSeats - lastOccupiedSeat[i] - 1;
                lastOccupiedSeat[i] = numberOfSeats - 1;
                lastFilledRow = i;
                if(lastFilledRow == numberOfRows - 1){
                    soldOut = true;
                }

            } else {
                lastOccupiedSeat[i] += k;
                break;
            }

        }
        totalNumberOfSeats -= k;
        return true;
    }
}


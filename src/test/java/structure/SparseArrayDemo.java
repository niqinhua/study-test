package structure;


import java.util.Arrays;

/**
 * 稀疏数组
 *
 * @author 倪勤华
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        System.out.println("一开始的棋盘模样：");
        Arrays.stream(chessArr).forEach(row -> {
            Arrays.stream(row).forEach(e -> System.out.printf("%d\t", e));
            System.out.println();
        });
        int[][] sparseArray = toSparseArray(chessArr);
        toArray(sparseArray);
    }

    private static int[][] toSparseArray(int[][] chessArr) {
        int sum = 0;
        for (int[] row : chessArr) {
            for (int e : row) {
                if (e != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessArr.length;
        sparseArray[0][1] = chessArr[0].length;
        sparseArray[0][2] = sum;
        int k = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    ++k;
                    sparseArray[k][0] = i;
                    sparseArray[k][1] = j;
                    sparseArray[k][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("稀疏数组的模样：");
        Arrays.stream(sparseArray).forEach(row -> {
            Arrays.stream(row).forEach(e -> System.out.printf("%d\t", e));
            System.out.println();
        });

        return sparseArray;
    }

    private static int[][] toArray(int[][] sparseArray) {
        int[][] returnArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            returnArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
       return returnArray;
    }
}

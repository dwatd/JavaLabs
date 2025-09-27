import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
      
        try (Scanner scan = new Scanner(System.in)) {
            Random random = new Random();

            System.out.print("Enter number of rows: ");
            int rows = scan.nextInt();

            System.out.print("Enter number of cols: ");
            int cols = scan.nextInt();

            if (rows <= 0 || cols <= 0 ) {
                throw new IllegalArgumentException("Rows and columns must be positive numbers!");
            }

            int[][] A = new int[rows][cols];
            int[][] B = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    A[i][j] = random.nextInt(100) + 1;
                    B[i][j] = random.nextInt(100) + 1;
                }
            }

            int[][] C = addMatrices(A, B);
            
            System.out.println("Matrix A:");
            printMatrix(A);
            System.out.println("\nMatrix B:");
            printMatrix(B);
            System.out.println("\nMatrix C:");
            printMatrix(C);

            int sum = calculateSum(C);
            System.out.println("\nSum is: " + sum);
        
        } catch (InputMismatchException error) {
            System.out.println("Please enter integers only.");
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    private static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;

        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    private static int calculateSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalSum = 0;

        for (int j = 0; j < cols; j++) {
            if (j % 2 == 0) {
                // максимумальні числа по парних стовпцях
                int maxInColumn = matrix[0][j];
                for (int i = 1; i < rows; i++) {
                    if (matrix[i][j] > maxInColumn) {
                        maxInColumn = matrix[i][j];
                    }
                }
                totalSum += maxInColumn;
            } else {
                // мінімальні числа по непарних стовпцях
                int minInColumn = matrix[0][j];
                for (int i = 1; i < rows; i++) {
                    if (matrix[i][j] < minInColumn) {
                        minInColumn = matrix[i][j];
                    }
                }
                totalSum += minInColumn;
            }
        }

        return totalSum;
    }
}

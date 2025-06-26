import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.io.FileNotFoundException;

public class MatrixProgram {

	public static void main(String[] args) {
		// CSV file path
                URL path = MatrixProgram.class.getResource("matrix.csv");
		File f = new File(path.getFile());
		String line = "";
		String csvSplitBy = ",";

		// Read the matrix from csv and place it in a dimensional array
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			int[][] matrix = null;
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] rowValues = line.split(csvSplitBy);
				int matrixDimension = rowValues.length;
				if (row == 0) {
					matrix = new int[matrixDimension][matrixDimension];
				}
				for (int col = 0; col < matrixDimension; col++) {
					matrix[row][col] = Integer.parseInt(rowValues[col]);
				}
				row++;
			}


			// print given matrix
			System.out.println("First Matrix:");
			printMatrix(matrix);
			System.out.println();

			// print transpose of a matrix
			System.out.println("Invert Matrix:");
			InvertMatrix(matrix);
			System.out.println();

			// print flatten matrix
			System.out.println("Flatten Matrix:");
			FlattenMatrix(matrix);
			System.out.println();

			//print sum of matrix
			System.out.println("Sum Matrix:");
			sumMatrix(matrix);
			System.out.println();

			//print multiply of matrix
			System.out.println("Multiply Matrix:");
			multiplyMatrix(matrix);
		} catch (FileNotFoundException fne) {
			System.out.println("CSV file does not exists in the specified path.");
			fne.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading matrix from CSV file..");
			// We use Logger to print the exception if the logger object is configured
			e.printStackTrace();
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + "\t");
			}
			System.out.println();
		}
	}

	private static void InvertMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[c][r] + "\t");
			}
			System.out.println();
		}
	}

	private static void FlattenMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c]);
				if (r < matrix.length - 1 || c < matrix.length - 1) {
					System.out.print(",");
				}
			}
		}
		System.out.println();
	}

	private static void sumMatrix(int[][] matrix) {
		int sum = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				sum += matrix[r][c];
			}
		}
		System.out.println(sum);
	}

	private static void multiplyMatrix(int[][] matrix) {
		int multiply = 1;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				multiply *= matrix[r][c];
			}
		}
		System.out.print(multiply);
	}
}
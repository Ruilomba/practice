import Model.TreeNode;

import java.util.*;

public class RotateMatrix {

    public static void rotateMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length / 2; i++){
            int[] nextArray = rotateRightSideMatrix(matrix, i);

            nextArray = rotateBottomMatrix(matrix, nextArray, i);
        }
    }

    public static void main(String[] args)   {

        int[][] matrix = new int[3][3];

        for(int i = 0; i < 3 * 3; i++){
                matrix[i / 3][i % 3] = i + 1;
        }

        rotateMatrix(matrix);
    }

    private static int[] rotateRightSideMatrix(int[][] matrix, int index){
        int[] nextRotation = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            nextRotation[matrix.length - 1 - i] = matrix[matrix.length - 1 - i][matrix.length - 1 - index];
            matrix[matrix.length - 1 - i][matrix.length - 1 - index] = matrix[index][matrix.length - 1 - i];
        }

        return nextRotation;
    }

    private static int[] rotateBottomMatrix(int[][] matrix, int[] currentRotation, int index){
        int[] nextRotation = new int[matrix.length];
        int temp = currentRotation[currentRotation.length - 1];
        for(int i = 0; i < currentRotation.length; i++){
            if(i == currentRotation.length - 1) nextRotation[i] = temp;
            else nextRotation[i] = matrix[matrix.length - 1 - index][i];
            matrix[matrix.length - 1 - index][i] = currentRotation[matrix.length - 1 - i];
        }

        return nextRotation;
    }
}

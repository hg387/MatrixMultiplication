import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        Double L1 = Double.valueOf(args[0]);
        Double L2 = Double.valueOf(args[1]);
        Double L3 = Double.valueOf(args[2]);

        Double theta1 = Double.valueOf(args[3]);
        Double theta2 = Double.valueOf(args[4]);
        Double theta3 = Double.valueOf(args[5]);

        String out = args[6];

        Matrix matrixL0 = new AllMatrices().getMatrixL0();
        Matrix matrixL1 = new AllMatrices().getMatrixL(L1);
        Matrix matrixL2 = new AllMatrices().getMatrixL(L2);
        Matrix matrixL3 = new AllMatrices().getMatrixL(L3);

        Stack<Matrix> stack = new Stack<>();
        List<Matrix> newLinks = new ArrayList<>();
        newLinks.add(matrixL0);

        List<List<Double>> M = new ArrayList<>();
        Matrix translateMatrix = new AllMatrices().translate(Arrays.asList(0.0, 0.0, 1.0));
        Matrix rotateMatrix = new AllMatrices().rotate(theta1, 3);
        Matrix multiply = new MatrixMultiplication().multiply(Arrays.asList(translateMatrix, rotateMatrix));
        stack.push(multiply);
        for (int i=0; i<matrixL1.getMatrix().size(); i++){
               List<Double> m = new ArrayList<>(matrixL1.getMatrix().get(i));
               m.add(1.0);
               List<Double> temp = new ArrayList<>();
               for (List<Double> t: multiply.getMatrix()){
                   Double result = (t.get(0)*m.get(0)) + (t.get(1)*m.get(1)) + (t.get(2)*m.get(2)) + (t.get(3)*m.get(3));
                   temp.add(result);
               }

               M.add(temp);
        }

        Matrix newM1 = new Matrix(M);
        newLinks.add(newM1);


        M = new ArrayList<>();
        translateMatrix = new AllMatrices().translate(Arrays.asList(0.0, 0.0, L1));
        rotateMatrix = new AllMatrices().rotate(theta2, 2);
        multiply = new MatrixMultiplication().multiply(Arrays.asList(stack.pop(), translateMatrix, rotateMatrix));
        stack.push(multiply);
        for (int i=0; i<matrixL2.getMatrix().size(); i++){
            List<Double> m =  new ArrayList<>(matrixL2.getMatrix().get(i));
            m.add(1.0);
            List<Double> temp = new ArrayList<>();
            for (List<Double> t: multiply.getMatrix()){
                Double result = (t.get(0)*m.get(0)) + (t.get(1)*m.get(1)) + (t.get(2)*m.get(2)) + (t.get(3)*m.get(3));
                temp.add(result);
            }

            M.add(temp);
        }

        newM1 = new Matrix(M);
        newLinks.add(newM1);


        M = new ArrayList<>();
        translateMatrix = new AllMatrices().translate(Arrays.asList(0.0, 0.0, L2));
        rotateMatrix = new AllMatrices().rotate(theta3, 2);
        multiply = new MatrixMultiplication().multiply(Arrays.asList(stack.pop(), translateMatrix, rotateMatrix));
        stack.push(multiply);
        for (int i=0; i<matrixL3.getMatrix().size(); i++){
            List<Double> m = new ArrayList<>(matrixL3.getMatrix().get(i));
            m.add(1.0);
            List<Double> temp = new ArrayList<>();
            for (List<Double> t: multiply.getMatrix()){
                Double result = (t.get(0)*m.get(0)) + (t.get(1)*m.get(1)) + (t.get(2)*m.get(2)) + (t.get(3)*m.get(3));
                temp.add(result);
            }

            M.add(temp);
        }

        newM1 = new Matrix(M);
        newLinks.add(newM1);


        translateMatrix = new AllMatrices().translate(Arrays.asList(0.0, 0.0, L3));
        newM1 = new MatrixMultiplication().multiply(Arrays.asList(stack.pop(),translateMatrix));
        newLinks.add(newM1);

        FileWriter.writeFile(out, newLinks);

    }
}

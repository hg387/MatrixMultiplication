
import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplication {

    public Matrix multiply(List<Matrix> matrices){
        Matrix matrix1 = matrices.get(0);
        for (int i=0; i<matrices.size()-1; i++){
            List<List<Double>> output = new ArrayList<>();

            Matrix matrix2 = matrices.get(i+1);

            Integer row1 = matrix1.getMatrix().size();
            Integer Column1 = matrix1.getMatrix().get(0).size();
            Integer row2 = matrix2.getMatrix().size();
            Integer Column2 = matrix2.getMatrix().get(0).size();

            if (Column1.equals(row2)){
//                if ((row1*Column1) == (row2*Column2)){
                    for (List<Double> row: matrix1.getMatrix()){
                        List<Double> newValues = new ArrayList<>();
                        Double x0 = row.get(0);
                        Double y0 = row.get(1);
                        Double z0 = row.get(2);
                        Double d0 = row.get(3);
                        Matrix inverseMatrix = matrix2.inverse();
                        for (List<Double> temp : inverseMatrix.getMatrix()){
                            Double x1 = temp.get(0);
                            Double y1 = temp.get(1);
                            Double z1 = temp.get(2);
                            Double d1 = temp.get(3);
                            Double result = (x0*x1) + (y0*y1) + (z0*z1) + (d0*d1);
                            newValues.add(result);
                        }
                        output.add(newValues);
//                    }
                }
            }

            matrix1 = new Matrix(output);
        }

        return matrix1;
    }
}

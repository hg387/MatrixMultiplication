import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllMatrices {

    public List<List<Integer>> triangleCoordinates(){
        List<List<Integer>> content = new ArrayList<List<Integer>>(){{
            add(Arrays.asList(0,1,2,0));
            add(Arrays.asList(0,2,3,0));
            add(Arrays.asList(7,6,5,7));
            add(Arrays.asList(7,5,4,7));
            add(Arrays.asList(0,3,7,0));
            add(Arrays.asList(0,7,4,0));
            add(Arrays.asList(1,5,6,1));
            add(Arrays.asList(1,6,2,1));
            add(Arrays.asList(0,4,5,0));
            add(Arrays.asList(0,5,1,0));
            add(Arrays.asList(3,2,6,3));
            add(Arrays.asList(3,6,7,3));
        }};


        return content;
    }

    public Matrix getMatrixL0(){
        List<List<Double>> content = new ArrayList<List<Double>>(){{
            add(Arrays.asList(-2.0, -2.0, 0.0));
            add(Arrays.asList(-2.0, 2.0, 0.0));
            add(Arrays.asList(2.0, 2.0, 0.0));
            add(Arrays.asList(2.0, -2.0, 0.0));
            add(Arrays.asList(-2.0, -2.0, 1.0));
            add(Arrays.asList(-2.0, 2.0, 1.0));
            add(Arrays.asList(2.0, 2.0, 1.0));
            add(Arrays.asList(2.0, -2.0, 1.0));
        }};

        Matrix L0 = new Matrix(content);

        return L0;
    }

    public Matrix getMatrixL(Double Ln){
        List<List<Double>> content = new ArrayList<List<Double>>(){{
            add(Arrays.asList(-0.5, -0.5, 0.0));
            add(Arrays.asList(-0.5, 0.5, 0.0));
            add(Arrays.asList(0.5, 0.5, 0.0));
            add(Arrays.asList(0.5, -0.5, 0.0));
            add(Arrays.asList(-0.5, -0.5, Ln));
            add(Arrays.asList(-0.5, 0.5, Ln));
            add(Arrays.asList(0.5, 0.5, Ln));
            add(Arrays.asList(0.5, -0.5, Ln));
        }};

        Matrix L = new Matrix(content);

        return L;
    }

    public Matrix translate(List<Double> axis){
        Double dx = axis.get(0);
        Double dy = axis.get(1);
        Double dz = axis.get(2);

        List<List<Double>> content = new ArrayList<List<Double>>(){{
            add(Arrays.asList(1.0, 0.0, 0.0, dx));
            add(Arrays.asList(0.0, 1.0, 0.0, dy));
            add(Arrays.asList(0.0, 0.0, 1.0, dz));
            add(Arrays.asList(0.0, 0.0, 0.0, 1.0));
        }};

        Matrix translateMatrix = new Matrix(content);

        return translateMatrix;
    }

    public Matrix rotate(Double degree, int axis){
        degree = Math.toRadians(degree);

        Double cosTheta = Math.cos(degree);
        Double sinTheta = Math.sin(degree);

        List<List<Double>> content = new ArrayList<List<Double>>();
        if (axis == 1){
            content.add(Arrays.asList(1.0, 0.0, 0.0, 0.0));
            content.add(Arrays.asList(0.0, cosTheta, -sinTheta, 0.0));
            content.add(Arrays.asList(0.0, sinTheta, cosTheta, 0.0));
            content.add(Arrays.asList(0.0, 0.0, 0.0, 1.0));
        }
        else if (axis == 2){
            content.add(Arrays.asList(cosTheta, 0.0, sinTheta, 0.0));
            content.add(Arrays.asList(0.0, 1.0, 0.0, 0.0));
            content.add(Arrays.asList(-sinTheta, 0.0, cosTheta, 0.0));
            content.add(Arrays.asList(0.0, 0.0, 0.0, 1.0));
        }
        else if (axis == 3){
            content.add(Arrays.asList(cosTheta, -sinTheta, 0.0, 0.0));
            content.add(Arrays.asList(sinTheta, cosTheta, 0.0, 0.0));
            content.add(Arrays.asList(0.0, 0.0, 1.0, 0.0));
            content.add(Arrays.asList(0.0, 0.0, 0.0, 1.0));
        }

        Matrix rotateMatrix = new Matrix(content);

        return rotateMatrix;
    }
}

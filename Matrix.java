package com.gupta.test.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
    private List<List<Double>> matrix;

    public List<List<Double>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Double>> matrix) {
        this.matrix = matrix;
    }

    public Matrix(List<List<Double>> matrix){
        this.matrix = matrix;
    }

    public Matrix inverse(){
        List<List<Double>> output = new ArrayList<>();
        if (this.matrix.get(0).size() != 1) {
            for (int i = 0; i < this.matrix.size(); i++) {
                List<Double> temp = new ArrayList<>();
                for (int j = 0; j < this.matrix.get(0).size(); j++) {
                    Double d = matrix.get(j).get(i);
                    temp.add(d);
                }
                output.add(temp);
            }
        }
        else{
            List<Double> temp = new ArrayList<>();
            for (List<Double> row: this.getMatrix()){
                temp.add(row.get(0));
            }
            output.add(temp);
        }

        return new Matrix(output);
    }
}

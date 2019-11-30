
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FileWriter {
    private static final String first = "#Inventor V2.0 ascii";
    private static final String second = "# Hierarchical Model Robot";

    public static void writeSpheres(BufferedWriter writer) throws IOException{
        writer.write("Separator {\nLightModel {\nmodel PHONG\n}\nMaterial {\n\tdiffuseColor 1.0 1.0 1.0\n}");
        writer.newLine();

        writer.write("Transform {\n\ttranslation");
        writer.write(" 0.0  0.0  0.0 ");
        writer.newLine();

        writer.write("}\nSphere {\n\tradius " + "0.20" + "\n}\n}");
        writer.newLine();
    }

    public static void writeSpheres(BufferedWriter writer, Matrix matrix) throws IOException{
        writer.write("Separator {\nLightModel {\nmodel PHONG\n}\nMaterial {\n\tdiffuseColor 1.0 1.0 1.0\n}");
        writer.newLine();

        writer.write("Transform {\n\ttranslation");
        String coordinates = "";
        for (int i = 0; i < matrix.getMatrix().size()-1; i++ ){
            String temp = (matrix.getMatrix().get(i).get(3)).toString();

            coordinates += (" " + temp + " ");
        }

        writer.write(coordinates);
        writer.newLine();

        writer.write("}\nSphere {\n\tradius " + "0.20" + "\n}\n}");
        writer.newLine();
    }

    public static void writeCoordinates(BufferedWriter writer, Matrix matrix) throws IOException{
        writer.write("Separator{\n\tCoordinate3 { \n\t\tpoint [");
        writer.newLine();

        for (List<Double> m: matrix.getMatrix()){
                String cordX = m.get(0).toString();
                String cordY = m.get(1).toString();
                String cordZ = m.get(2).toString();
                writer.write("\t\t\t"+ cordX + " " + cordY + " " + cordZ + ",");
                writer.newLine();

        }

        writer.write("\t\t]\n\t}");
        writer.newLine();

        writer.write("\tIndexedLineSet {\n\t\t" +
                "coordIndex [");
        writer.newLine();

        List<List<Integer>> triangleCoords = new AllMatrices().triangleCoordinates();

        for(List<Integer> coords: triangleCoords){
            String cordX = coords.get(0).toString();
            String cordY = coords.get(1).toString();
            String cordZ = coords.get(2).toString();
            String d = coords.get(3).toString();
            writer.write("\t\t\t"+ cordX + ", " + cordY + ", " + cordZ + ", " + d + ", -1,");
            writer.newLine();
        }

        writer.write("\t\t]\n\t}\n}");
        writer.newLine();
    }


    public static void writeFile(String out, List<Matrix> links) throws Exception{
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(out))){
            writer.write(first);
            writer.newLine();

            writer.write(second);
            writer.newLine();
            writer.newLine();

            writeCoordinates(writer, links.get(0));
            writeCoordinates(writer, links.get(1));
            writeCoordinates(writer, links.get(2));
            writeCoordinates(writer, links.get(3));
            writeSpheres(writer);
            writeSpheres(writer, links.get(4));


        }
        catch(IOException e){
            System.out.println("Exception Thrown : " + e);
        }
    }
}

import java.io.*;

public class CSVtoJSON {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        FileInputStream fis = new FileInputStream(file);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));


        String line = br.readLine();
        String[] names = line.split(",");
        for (int i = 0; i < names.length; ++i) names[i] = names[i].trim();

        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            sb.append("{\"index\":{\"_id\":\"").append(values[0]).append("\"}}\n{");
            for (int i = 0; i < values.length; ++i) {
                if (i < values.length - 1) {
                    sb.append("\"").append(names[i]).append("\":\"").append(values[i].trim()).append("\",");
                } else {
                    sb.append("\"").append(names[i]).append("\":\"").append(values[i].trim()).append("\"}\n");
                }
            }
        }

        writer.write(sb.toString());
        writer.close();
        br.close();
    }
}

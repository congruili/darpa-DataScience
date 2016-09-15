import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProcessAndStepTripleGenerator {

    public static void main(String[] args) throws IOException {
        int nLoops = Integer.parseInt(args[0]);
        int nSteps = Integer.parseInt(args[1]);

        if ((args.length - 4) != nSteps) {
            System.out.println("Wrong number of arguments!!!");
            return;
        }

        String[] loops = new String[nLoops];
        String[][] steps = new String[nLoops][nSteps];

        for (int i = 0; i < nLoops; ++i) {
            loops[i] = args[2] + "_" + (i + 1) + "_of_" + nLoops;
        }

        for (int i = 0; i < nLoops; ++i) {
            for (int j = 0; j < nSteps; ++j) {
                steps[i][j] = args[j + 3] + "_" + (i + 1) + "_of_" + nLoops;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nLoops; ++i) {
            sb.append(new Loop(i, loops, steps[i]).printLoop()).append("\n\n");

            for (int j = 0; j < nSteps; ++j) {
                sb.append(new Step(j, steps[i]).printStep()).append("\n\n");
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(args[args.length - 1]));
        writer.write(sb.toString());
        writer.close();
        //System.out.println(sb.toString());
    }
}

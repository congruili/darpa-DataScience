public class Loop {
    private int curtLoop, nLoops;
    private String[] loops;
    private String[] steps;

    public Loop(int curtLoop, String[] loops, String[] steps) {
        this.curtLoop = curtLoop;
        this.nLoops = loops.length;
        this.loops = loops;
        this.steps = steps;
    }

    public String printLoop() {
        String curt = loops[curtLoop];
        String firstSpace = new String(new char[curt.length() + 1]).replace('\0', ' ');
        String hasStep = "ampo:hasStep ";
        String secondSpace = new String(new char[hasStep.length()]).replace('\0', ' ');

        StringBuilder sb = new StringBuilder();
        sb.append("###  https://tw.rpi.edu/web/project/ampo#").append(curt.substring(5)).append("\n");
        sb.append(curt).append(" rdf:type ampo:Process ;\n");
        if (curtLoop != nLoops - 1) sb.append(firstSpace).append("ampo:happensDirectlyBefore ").append(loops[curtLoop+1]).append(" ;\n");
        sb.append(firstSpace + hasStep).append(steps[0]).append(" ,\n");
        int ind = 1;
        while (ind < steps.length - 1) {
            sb.append(firstSpace + secondSpace).append(steps[ind]).append(" ,\n");
            ++ind;
        }
        sb.append(firstSpace + secondSpace).append(steps[ind]).append(" ;\n");

        String label = curt.substring(5).replace("_", " ");
        sb.append(firstSpace).append("rdfs:label \"").append(label).append("\" .\n");
        return sb.toString();
    }
}

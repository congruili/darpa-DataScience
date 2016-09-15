public class Step {
    private int curtStep, nSteps;
    private String[] steps;


    public Step(int curtStep, String[] steps) {
        this.curtStep = curtStep;
        this.nSteps = steps.length;
        this.steps = steps;
    }

    public String printStep() {
        String curt = steps[curtStep];
        String space = new String(new char[curt.length() + 1]).replace('\0', ' ');
        StringBuilder sb = new StringBuilder();
        sb.append("###  https://tw.rpi.edu/web/project/ampo#").append(curt.substring(5)).append("\n");
        sb.append(curt).append(" rdf:type ampo:Step ;\n");
        if (curtStep != nSteps - 1) sb.append(space).append("ampo:happensDirectlyBefore ").append(steps[curtStep+1]).append(" ;\n");
        String label = curt.substring(5).replace("_", " ");
        sb.append(space).append("rdfs:label \"").append(label).append("\" .\n");
        return sb.toString();
    }
}

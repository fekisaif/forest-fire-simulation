package ForestFireSimulation;

public class FireController {
    private FireSpreadSimulation simulation;

    public FireController(FireSpreadSimulation simulation) {
        this.simulation = simulation;
    }

    public void run() {
        while (!simulation.isFinished()) {
            simulation.step();
            try {
                Thread.sleep(1000); // For demonstration purposes, to slow down the simulation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

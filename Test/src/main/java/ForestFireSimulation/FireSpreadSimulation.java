package ForestFireSimulation;

public class FireSpreadSimulation {
    private Forest forest;

    public FireSpreadSimulation(Forest forest) {
        this.forest = forest;
    }

    public void step() {
        forest.spreadFire();
    }

    public boolean isFinished() {
        return !forest.hasBurningCells();
    }

    public Forest getForest() {
        return forest;
    }
}

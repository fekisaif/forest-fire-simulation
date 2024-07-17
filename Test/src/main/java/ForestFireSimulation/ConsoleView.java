package ForestFireSimulation;

import observer.Observer;

public class ConsoleView implements Observer {
    private Forest forest;

    public ConsoleView(Forest forest) {
        this.forest = forest;
    }

    @Override
    public void update() {
        display();
    }

    public void display() {
        char[][] grid = forest.getGrid();
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println(); // Pour ajouter une ligne vide entre les étapes

    }
}

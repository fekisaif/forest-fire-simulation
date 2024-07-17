package ForestFireSimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import observer.Subject;
import observer.Observer;

public class Forest implements Subject {
    private char[][] grid;
    private final int height;
    private final int width;
    private double spreadProbability;
    private List<Observer> observers;

    public Forest(int height, int width, double spreadProbability) {
        this.height = height;
        this.width = width;
        this.spreadProbability = spreadProbability;
        grid = new char[height][width];
        observers = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = 'T';
                // T pour les cases qui contiennent forét vert 
            }
        }
    }
    	//Vérifie si les coordonnées (i, j) se trouvent à l'intérieur des limites de la grille.
    public boolean isInBounds(int i, int j) {
        return i >= 0 && i < height && j >= 0 && j < width;
    }

    public boolean isTree(int i, int j) {
        return grid[i][j] == 'T';
    }

    public boolean isBurning(int i, int j) {
        return grid[i][j] == 'F';
    }

    public void setBurning(int i, int j) {
        grid[i][j] = 'F'; // F pour les cases en feu
        notifyObservers();
    }

    public void extinguish(int i, int j) {
        grid[i][j] = 'A'; // A pour les cases en cendres
    }

    public boolean hasBurningCells() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == 'F') {
                    return true;
                }
            }
        }
        return false;
    }

    public void spreadFire() {
        Forest nextForest = this.clone();
        Random rand = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isBurning(i, j)) {
                    nextForest.extinguish(i, j);
                    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                    for (int[] dir : directions) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (isInBounds(newRow, newCol) && isTree(newRow, newCol)) {
                            if (rand.nextDouble() < spreadProbability) {
                                nextForest.setBurning(newRow, newCol);
                            }
                        }
                    }
                }
            }
        }
        this.grid = nextForest.grid;
        notifyObservers();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getGrid() {
        return grid;
    }



    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    @Override
    public Forest clone() {
        Forest clone = new Forest(height, width, spreadProbability);
        for (int i = 0; i < height; i++) {
            System.arraycopy(this.grid[i], 0, clone.grid[i], 0, width);
        }
        return clone;
    }

	@Override
	public void attach(Observer o) {
        observers.add(o);
        System.out.println("Observateur attaché: " + o.getClass().getSimpleName());
	}

	@Override
	public void detach(Observer o) {
        observers.remove(o);
	}
   
}

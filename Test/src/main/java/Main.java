import java.io.IOException;

import ForestFireSimulation.Config;
import ForestFireSimulation.ConsoleView;
import ForestFireSimulation.FireController;
import ForestFireSimulation.FireSpreadSimulation;
import ForestFireSimulation.Forest;

public class Main {
    public static void main(String[] args) {
        try {
            Config config = new Config("config.properties");

            int height = config.getGridHeight();
            int width = config.getGridWidth();
            String[] initialFires = config.getInitialFires().split(";");
            double spreadProbability = config.getSpreadProbability();

            Forest forest = new Forest(height, width, spreadProbability);
            for (String fire : initialFires) {
                String[] position = fire.split(",");
                int x = Integer.parseInt(position[0].trim());
                int y = Integer.parseInt(position[1].trim());
                forest.setBurning(x, y);            }

            FireSpreadSimulation simulation = new FireSpreadSimulation(forest);
            ConsoleView view = new ConsoleView(forest);
            forest.attach(view);
            FireController controller = new FireController(simulation);
            controller.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

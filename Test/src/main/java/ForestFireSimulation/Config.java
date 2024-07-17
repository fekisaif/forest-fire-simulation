package ForestFireSimulation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private Properties properties = new Properties();

    public Config(String filePath) throws IOException {
        FileInputStream input = new FileInputStream(filePath);
        properties.load(input);
        input.close();
    }

    public int getGridHeight() {
        return Integer.parseInt(properties.getProperty("hauteur"));
    }

    public int getGridWidth() {
        return Integer.parseInt(properties.getProperty("largeur"));
    }

    public String getInitialFires() {
        return properties.getProperty("feusInitiales");
    }

    public double getSpreadProbability() {
        return Double.parseDouble(properties.getProperty("probabilite"));
    }
}

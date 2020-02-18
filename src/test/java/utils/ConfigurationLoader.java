package utils;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

public class ConfigurationLoader {

    private static Map<String, String> config;

    private static Map<String, String> initialise() {
        Constructor constructor = new Constructor(Map.class);
        String fileName = "";
//        fileName = Optional.ofNullable(System.getProperty("environment")).orElse("test") + ".yml";
        InputStream input = ConfigurationLoader.class.getClassLoader().getResourceAsStream("config/test.yml");
        System.out.println();
        Yaml yaml = new Yaml();
        config = (Map<String, String>) yaml.load(input);
        return config;
    }


    public static Map<String, String> config() {
        if (config == null) {
            return initialise();
        } else {
            return config;
        }
    }

}


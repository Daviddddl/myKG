package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Neo4jConfig {

    public HashMap getNeo4jConfig() throws IOException {

        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("neo4j.properties"));

        HashMap<String, Object> neo4jConfigHM = new HashMap<>();
        neo4jConfigHM.put("url", prop.getProperty("url"));
        neo4jConfigHM.put("user", prop.getProperty("user"));
        neo4jConfigHM.put("password", prop.getProperty("password"));

        return neo4jConfigHM;
    }

    public Neo4jUtil getNeo4j() throws IOException {
        HashMap neo4jConfig = getNeo4jConfig();
        return new Neo4jUtil(
                (String)neo4jConfig.get("url"),
                (String)neo4jConfig.get("user"),
                (String)neo4jConfig.get("password")
        );
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Neo4jConfig().getNeo4j());
    }
}

package utils;

import org.neo4j.driver.v1.*;

public class Neo4jUtil implements AutoCloseable{

    private final Driver driver;

    public Neo4jUtil(String uri, String user, String password) {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() {
        driver.close();
    }

    public StatementResult myNeo4j(final String command) {
        try ( Session session = driver.session() ) {
            return session.writeTransaction(tx -> tx.run(command));
        }
    }
}

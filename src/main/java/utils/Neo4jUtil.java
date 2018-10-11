package utils;

import org.neo4j.driver.v1.*;

import java.io.IOException;

public class Neo4jUtil implements AutoCloseable{
    private final Driver driver;

    public Neo4jUtil(String uri, String user, String password)
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    public Neo4jUtil(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void close() {
        driver.close();
    }

    public void myNeo4j(final String command) {

        try ( Session session = driver.session() ) {
            String greeting = session.writeTransaction( new TransactionWork<String>() {
                @Override
                public String execute( Transaction tx ) {
                    return tx.run(command).toString();
                }
            } );
//            System.out.println(greeting);
        }
    }
}

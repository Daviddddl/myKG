package operation;

import dataobject.Langual;
import utils.Neo4jUtil;

import java.io.IOException;

public class DeleteRelations {

    public static void deleteExample() throws IOException {
        /*
         * delete Langual -> Langual Factors Description File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        Langual.getAllLangualList().forEach(langual -> {
            String cmd = "MATCH (n:Langual)-[r:lang_desc]-(b:Langdesc) where n.factorCode='"
            + langual.getFactorCode().trim()
            + "' delete r";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });
    }
}

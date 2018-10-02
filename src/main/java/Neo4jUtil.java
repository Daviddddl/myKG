import dataobject.DataSrc;
import dataobject.FoodDes;
import org.neo4j.driver.v1.*;

import java.io.IOException;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class Neo4jUtil implements AutoCloseable{
    private final Driver driver;

    private Neo4jUtil(String uri, String user, String password)
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

    private void myNeo4j(final String command) {

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

    public static void main(String[] args) throws IOException {
        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );
        /*FoodDes.getAllFoodDesList().forEach(foodDes -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:FoodDes { ndbNo: \'" + foodDes.getNdbNo() + "\', "
                            + "fdGrpCd: \'" + foodDes.getFdGrpCd() + "\', "
                            + "longDesc: \'" + foodDes.getLongDesc() + "\', "
                            + "shrtDesc: \'" + foodDes.getShrtDesc() + "\', "
                            + "comName: \'" + foodDes.getComName() + "\', "
                            + "manufacName: \'" + foodDes.getManufacName() + "\', "
                            + "survey: \'" + foodDes.getSurvey() + "\', "
                            + "refDesc: \'" + foodDes.getRefDesc() + "\', "
                            + "refuse: \'" + foodDes.getRefuse() + "\', "
                            + "sciName: \'" + foodDes.getSciName() + "\', "
                            + "nFactor: \'" + foodDes.getNFactor() + "\', "
                            + "proFactor: \'" + foodDes.getProFactor() + "\', "
                            + "fatFactor: \'" + foodDes.getFatFactor() + "\', "
                            + "choFactor: \'" + foodDes.getChoFactor() + "\' })");
            System.out.println(foodDes);
        });*/

        /*DataSrc.getAllDataSrcList().forEach(dataSrc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:FoodDes { dataSrcId: \'" + dataSrc.getDataSrcId() + "\', "
                            + "authors: \'" + dataSrc.getAuthors() + "\', "
                            + "title: \'" + dataSrc.getTitle() + "\', "
                            + "year: \'" + dataSrc.getYear() + "\', "
                            + "journal: \'" + dataSrc.getJournal() + "\', "
                            + "volCity: \'" + dataSrc.getVolCity() + "\', "
                            + "issueState: \'" + dataSrc.getIssueState() + "\', "
                            + "startPage: \'" + dataSrc.getStartPage() + "\', "
                            + "endPage: \'" + dataSrc.getEndPage() + "\' })");
            System.out.println(dataSrc);
        });*/

        /*DataSrc.getAllDataSrcList().forEach(dataSrc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:FoodDes { dataSrcId: \'" + dataSrc.getDataSrcId() + "\', "
                            + "authors: \'" + dataSrc.getAuthors() + "\', "
                            + "title: \'" + dataSrc.getTitle() + "\', "
                            + "year: \'" + dataSrc.getYear() + "\', "
                            + "journal: \'" + dataSrc.getJournal() + "\', "
                            + "volCity: \'" + dataSrc.getVolCity() + "\', "
                            + "issueState: \'" + dataSrc.getIssueState() + "\', "
                            + "startPage: \'" + dataSrc.getStartPage() + "\', "
                            + "endPage: \'" + dataSrc.getEndPage() + "\' })");
            System.out.println(dataSrc);
        });*/

        neo4jUtil.close();
    }
}

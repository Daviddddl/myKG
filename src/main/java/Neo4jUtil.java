import dataobject.*;
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
        });

        DataSrc.getAllDataSrcList().forEach(dataSrc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:DataSrc { dataSrcId: \'" + dataSrc.getDataSrcId() + "\', "
                            + "authors: \'" + dataSrc.getAuthors() + "\', "
                            + "title: \'" + dataSrc.getTitle() + "\', "
                            + "year: \'" + dataSrc.getYear() + "\', "
                            + "journal: \'" + dataSrc.getJournal() + "\', "
                            + "volCity: \'" + dataSrc.getVolCity() + "\', "
                            + "issueState: \'" + dataSrc.getIssueState() + "\', "
                            + "startPage: \'" + dataSrc.getStartPage() + "\', "
                            + "endPage: \'" + dataSrc.getEndPage() + "\' })");
            System.out.println(dataSrc);
        });

        Datsrcln.getAllDatsrclnList().forEach(datsrcln -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Datsrcln { dataSrcId: \'" + datsrcln.getDataSrcId() + "\', "
                            + "ndbNo: \'" + datsrcln.getNdbNo() + "\', "
                            + "nutrNo: \'" + datsrcln.getNutrNo() + "\' })");
            System.out.println(datsrcln);
        });

        DerivCd.getAllDerivCdList().forEach(derivCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:DerivCd { derivCd: \'" + derivCd.getDerivCd() + "\', "
                            + "derivDesc: \'" + derivCd.getDerivDesc() + "\' })");
            System.out.println(derivCd);
        });

        FdGroup.getAllFdGroupList().forEach(fdGroup -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:FdGroup { fdGrpCd: \'" + fdGroup.getFdGrpCd() + "\', "
                            + "fdGrpDesc: \'" + fdGroup.getFdGrpDesc() + "\' })");
            System.out.println(fdGroup);
        });

        Footnote.getAllFootnoteList().forEach(footnote -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Footnote { footntNo: \'" + footnote.getFootntNo() + "\', "
                            + "ndbNo: \'" + footnote.getNdbNo() + "\', "
                            + "footntTxt: \'" + footnote.getFootntTxt() + "\', "
                            + "footntTyp: \'" + footnote.getFootntTyp() + "\', "
                            + "nutrNo: \'" + footnote.getNutrNo() + "\' })");
            System.out.println(footnote);
        });

        Langdesc.getAllLangdescList().forEach(langdesc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langdesc { description: \'" + langdesc.getDescription() + "\', "
                            + "factorCode: \'" + langdesc.getFactorCode() + "\' })");
            System.out.println(langdesc);
        });

        Langual.getAllLangualList().forEach(langual -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langual { factorCode: \'" + langual.getFactorCode() + "\', "
                            + "ndbNo: \'" + langual.getNdbNo() + "\' })");
            System.out.println(langual);
        });

        NutData.getAllNutDataList().forEach(nutData -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:NutData { addmodDate: \'" + nutData.getAddmodDate() + "\', "
                            + "addNutrMark: \'" + nutData.getAddNutrMark() + "\', "
                            + "derivCd: \'" + nutData.getDerivCd() + "\', "
                            + "df: \'" + nutData.getDf() + "\', "
                            + "lowEb: \'" + nutData.getLowEb() + "\', "
                            + "max: \'" + nutData.getMax() + "\', "
                            + "min: \'" + nutData.getMin() + "\', "
                            + "ndbNo: \'" + nutData.getNdbNo() + "\', "
                            + "numDataPts: \'" + nutData.getNumDataPts() + "\', "
                            + "numStudies: \'" + nutData.getNumStudies() + "\', "
                            + "nutrNo: \'" + nutData.getNutrNo() + "\', "
                            + "nutrVal: \'" + nutData.getNutrVal() + "\', "
                            + "refNdbNo: \'" + nutData.getRefNdbNo() + "\', "
                            + "srcCd: \'" + nutData.getSrcCd() + "\', "
                            + "statCmt: \'" + nutData.getStatCmt() + "\', "
                            + "stdError: \'" + nutData.getStdError() + "\', "
                            + "upEb: \'" + nutData.getUpEb() + "\' })");
            System.out.println(nutData);
        });

        NutrDef.getAllNutrDefList().forEach(nutrDef -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:NutrDef { numDec: \'" + nutrDef.getNumDec() + "\', "
                            + "nutrDesc: \'" + nutrDef.getNutrDesc() + "\', "
                            + "nutrNo: \'" + nutrDef.getNutrNo() + "\', "
                            + "srOrder: \'" + nutrDef.getSrOrder() + "\', "
                            + "tagName: \'" + nutrDef.getTagname() + "\', "
                            + "units: \'" + nutrDef.getUnits() + "\' })");
            System.out.println(nutrDef);
        });

        SrcCd.getAllSrcCdList().forEach(srcCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:SrcCd { srcCd: \'" + srcCd.getSrcCd() + "\', "
                            + "srcCdDesc: \'" + srcCd.getSrcCdDesc() + "\' })");
            System.out.println(srcCd);
        });

        Weight.getAllWeightList().forEach(weight -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Weight { amount: \'" + weight.getAmount() + "\', "
                            + "gmWgt: \'" + weight.getGmWgt() + "\', "
                            + "msreDesc: \'" + weight.getMsreDesc() + "\', "
                            + "ndbNo: \'" + weight.getNdbNo() + "\', "
                            + "numDataPts: \'" + weight.getNumDataPts() + "\', "
                            + "seq: \'" + weight.getSeq() + "\', "
                            + "getStdDev: \'" + weight.getStdDev() + "\' })");
            System.out.println(weight);
        });*/



//        MATCH (a:Person),(b:Person) WHERE a.name = 'A' AND b.name = 'B' CREATE (a)-[r:RELTYPE]->(b) RETURN type(r)

        neo4jUtil.close();
    }
}

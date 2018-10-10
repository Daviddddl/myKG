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
                    "CREATE (n:FoodDes { ndbNo: \'" + foodDes.getNdbNo().trim() + "\', "
                            + "fdGrpCd: \'" + foodDes.getFdGrpCd().trim() + "\', "
                            + "longDesc: \'" + foodDes.getLongDesc().trim() + "\', "
                            + "shrtDesc: \'" + foodDes.getShrtDesc().trim() + "\', "
                            + "comName: \'" + foodDes.getComName().trim() + "\', "
                            + "manufacName: \'" + foodDes.getManufacName().trim() + "\', "
                            + "survey: \'" + foodDes.getSurvey().trim() + "\', "
                            + "refDesc: \'" + foodDes.getRefDesc().trim() + "\', "
                            + "refuse: \'" + foodDes.getRefuse().trim() + "\', "
                            + "sciName: \'" + foodDes.getSciName().trim() + "\', "
                            + "nFactor: \'" + foodDes.getNFactor().trim() + "\', "
                            + "proFactor: \'" + foodDes.getProFactor().trim() + "\', "
                            + "fatFactor: \'" + foodDes.getFatFactor().trim() + "\', "
                            + "choFactor: \'" + foodDes.getChoFactor().trim() + "\' })");
            System.out.println(foodDes);
        });

        DataSrc.getAllDataSrcList().forEach(dataSrc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:DataSrc { dataSrcId: \'" + dataSrc.getDataSrcId().trim() + "\', "
                            + "authors: \'" + dataSrc.getAuthors().trim() + "\', "
                            + "title: \'" + dataSrc.getTitle().trim() + "\', "
                            + "year: \'" + dataSrc.getYear().trim() + "\', "
                            + "journal: \'" + dataSrc.getJournal().trim() + "\', "
                            + "volCity: \'" + dataSrc.getVolCity().trim() + "\', "
                            + "issueState: \'" + dataSrc.getIssueState().trim() + "\', "
                            + "startPage: \'" + dataSrc.getStartPage().trim() + "\', "
                            + "endPage: \'" + dataSrc.getEndPage().trim() + "\' })");
            System.out.println(dataSrc);
        });

        Datsrcln.getAllDatsrclnList().forEach(datsrcln -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Datsrcln { dataSrcId: \'" + datsrcln.getDataSrcId().trim() + "\', "
                            + "ndbNo: \'" + datsrcln.getNdbNo().trim() + "\', "
                            + "nutrNo: \'" + datsrcln.getNutrNo().trim().trim() + "\' })");
            System.out.println(datsrcln);
        });

        DerivCd.getAllDerivCdList().forEach(derivCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:DerivCd { derivCd: \'" + derivCd.getDerivCd().trim() + "\', "
                            + "derivDesc: \'" + derivCd.getDerivDesc().trim()+ "\' })");
            System.out.println(derivCd);
        });

        FdGroup.getAllFdGroupList().forEach(fdGroup -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:FdGroup { fdGrpCd: \'" + fdGroup.getFdGrpCd().trim() + "\', "
                            + "fdGrpDesc: \'" + fdGroup.getFdGrpDesc().trim() + "\' })");
            System.out.println(fdGroup);
        });

        Footnote.getAllFootnoteList().forEach(footnote -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Footnote { footntNo: \'" + footnote.getFootntNo().trim() + "\', "
                            + "ndbNo: \'" + footnote.getNdbNo().trim() + "\', "
                            + "footntTxt: \'" + footnote.getFootntTxt().trim() + "\', "
                            + "footntTyp: \'" + footnote.getFootntTyp().trim() + "\', "
                            + "nutrNo: \'" + footnote.getNutrNo().trim() + "\' })");
            System.out.println(footnote);
        });

        Langdesc.getAllLangdescList().forEach(langdesc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langdesc { description: \'" + langdesc.getDescription().trim() + "\', "
                            + "factorCode: \'" + langdesc.getFactorCode().trim() + "\' })");
            System.out.println(langdesc);
        });

        Langual.getAllLangualList().forEach(langual -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langual { factorCode: \'" + langual.getFactorCode().trim() + "\', "
                            + "ndbNo: \'" + langual.getNdbNo().trim() + "\' })");
            System.out.println(langual);
        });

        NutData.getAllNutDataList().forEach(nutData -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:NutData { addmodDate: \'" + nutData.getAddmodDate().trim() + "\', "
                            + "addNutrMark: \'" + nutData.getAddNutrMark().trim() + "\', "
                            + "derivCd: \'" + nutData.getDerivCd().trim() + "\', "
                            + "df: \'" + nutData.getDf().trim() + "\', "
                            + "lowEb: \'" + nutData.getLowEb().trim() + "\', "
                            + "max: \'" + nutData.getMax().trim() + "\', "
                            + "min: \'" + nutData.getMin().trim() + "\', "
                            + "ndbNo: \'" + nutData.getNdbNo().trim() + "\', "
                            + "numDataPts: \'" + nutData.getNumDataPts().trim() + "\', "
                            + "numStudies: \'" + nutData.getNumStudies().trim() + "\', "
                            + "nutrNo: \'" + nutData.getNutrNo().trim() + "\', "
                            + "nutrVal: \'" + nutData.getNutrVal().trim() + "\', "
                            + "refNdbNo: \'" + nutData.getRefNdbNo().trim() + "\', "
                            + "srcCd: \'" + nutData.getSrcCd().trim() + "\', "
                            + "statCmt: \'" + nutData.getStatCmt().trim() + "\', "
                            + "stdError: \'" + nutData.getStdError().trim() + "\', "
                            + "upEb: \'" + nutData.getUpEb().trim() + "\' })");
            System.out.println(nutData);
        });

        NutrDef.getAllNutrDefList().forEach(nutrDef -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:NutrDef { numDec: \'" + nutrDef.getNumDec().trim() + "\', "
                            + "nutrDesc: \'" + nutrDef.getNutrDesc().trim() + "\', "
                            + "nutrNo: \'" + nutrDef.getNutrNo().trim() + "\', "
                            + "srOrder: \'" + nutrDef.getSrOrder().trim() + "\', "
                            + "tagName: \'" + nutrDef.getTagname().trim() + "\', "
                            + "units: \'" + nutrDef.getUnits().trim() + "\' })");
            System.out.println(nutrDef);
        });

        SrcCd.getAllSrcCdList().forEach(srcCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:SrcCd { srcCd: \'" + srcCd.getSrcCd().trim() + "\', "
                            + "srcCdDesc: \'" + srcCd.getSrcCdDesc().trim() + "\' })");
            System.out.println(srcCd);
        });

        Weight.getAllWeightList().forEach(weight -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Weight { amount: \'" + weight.getAmount().trim() + "\', "
                            + "gmWgt: \'" + weight.getGmWgt().trim() + "\', "
                            + "msreDesc: \'" + weight.getMsreDesc().trim() + "\', "
                            + "ndbNo: \'" + weight.getNdbNo().trim() + "\', "
                            + "numDataPts: \'" + weight.getNumDataPts().trim() + "\', "
                            + "seq: \'" + weight.getSeq().trim() + "\', "
                            + "getStdDev: \'" + weight.getStdDev().trim() + "\' })");
            System.out.println(weight);
        });*/



        //        MATCH (a:Person),(b:Person) WHERE a.name = 'A' AND b.name = 'B' CREATE (a)-[r:RELTYPE]->(b) RETURN type(r)

        /*
         * FoodDes -> FoodGroupDescription
         */
        /*FdGroup.getAllFdGroupList().forEach(fdGroup -> {
            String cmd = "MATCH (a:FoodDes),(b:FdGroup) WHERE a.fdGrpCd = '"
                    + fdGroup.getFdGrpCd().trim()
                    + "' AND b.fdGrpCd = '"
                    + fdGroup.getFdGrpCd().trim()
                    + "' CREATE (a)-[r:"
                    + "group"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/

        /*
         * FoodDes -> Footnote
         */
        /*FoodDes.getAllFoodDesList().forEach(foodDes -> {
            String cmd = "MATCH (a:FoodDes),(b:Footnote) WHERE a.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "footnote"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/

        /*
         * FoodDes -> Nutrient Date File
         *//*
        FoodDes.getAllFoodDesList().forEach(foodDes -> {
            String cmd = "MATCH (a:FoodDes),(b:NutData) WHERE a.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "fooddes_nut_data"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        *//*
         * Footnote -> Nutrient Date File
         *//*
        Footnote.getAllFootnoteList().forEach(footnote -> {
            String cmd = "MATCH (a:Footnote),(b:NutData) WHERE a.ndbNo = '"
                    + footnote.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + footnote.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "footnote_nut_data"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        *//*
         * FoodDes -> Nutrient Date File
         *//*
        FoodDes.getAllFoodDesList().forEach(foodDes -> {
            String cmd = "MATCH (a:FoodDes),(b:Weight) WHERE a.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "weight"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        *//*
         * FoodDes -> Langual
         *//*
        FoodDes.getAllFoodDesList().forEach(foodDes -> {
            String cmd = "MATCH (a:FoodDes),(b:Langual) WHERE a.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "langual"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/


        /*
         * delete Langual -> Langual Factors Description File
         */
        /*Langual.getAllLangualList().forEach(langual -> {
            String cmd = "MATCH (n:Langual)-[r:lang_desc]-(b:Langdesc) where n.factorCode='"
            + langual.getFactorCode().trim()
            + "' delete r";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/


        /*
         * Langual -> Langual Factors Description File
         */
        /*Langdesc.getAllLangdescList().forEach(langdesc -> {
            String cmd = "MATCH (a:Langual),(b:Langdesc) WHERE a.factorCode = '"
                    + langdesc.getFactorCode().trim()
                    + "' AND b.factorCode = '"
                    + langdesc.getFactorCode().trim()
                    + "' CREATE (a)-[r:"
                    + "lang_desc"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/


        /*
         * Nutrient Data File -> Nutrient Definition File
         */
        /*NutrDef.getAllNutrDefList().forEach(nutrDef -> {
            String cmd = "MATCH (a:NutData),(b:NutrDef) WHERE a.nutrNo = '"
                    +  nutrDef.getNutrNo().trim()
                    + "' AND b.nutrNo = '"
                    + nutrDef.getNutrNo().trim()
                    + "' CREATE (a)-[r:"
                    + "nutr_def"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/

        /*
         * Nutrient Data File -> Source Code File
         */
        /*SrcCd.getAllSrcCdList().forEach(srcCd -> {
            String cmd = "MATCH (a:NutData),(b:SrcCd) WHERE a.srcCd = '"
                    +  srcCd.getSrcCd().trim()
                    + "' AND b.srcCd = '"
                    + srcCd.getSrcCd().trim()
                    + "' CREATE (a)-[r:"
                    + "src_code"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/

        /*
         * Nutrient Data File -> Data Derivation Code
         */
        /*DerivCd.getAllDerivCdList().forEach(derivCd -> {
            String cmd = "MATCH (a:NutData),(b:DerivCd) WHERE a.derivCd = '"
                    +  derivCd.getDerivCd().trim()
                    + "' AND b.derivCd = '"
                    + derivCd.getDerivCd().trim()
                    + "' CREATE (a)-[r:"
                    + "data_derivation"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/

        /*
         * Nutrient Data File -> Sources of Data Link File
         */
        /*FoodDes.getAllFoodDesList().forEach(foodDes -> {
            String cmd = "MATCH (a:FoodDes),(b:Datsrcln) WHERE a.ndbNo = '"
                    +  foodDes.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "src_data_link"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/

        /*
         * Sources of Data Link File -> Sources of Data File
         */
        /*DataSrc.getAllDataSrcList().forEach(dataSrc -> {
            String cmd = "MATCH (a:DataSrc),(b:Datsrcln) WHERE a.dataSrcId = '"
                    +  dataSrc.getDataSrcId().trim()
                    + "' AND b.dataSrcId = '"
                    + dataSrc.getDataSrcId().trim()
                    + "' CREATE (a)-[r:"
                    + "src_data_file"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });*/


        neo4jUtil.close();
    }
}

package operation;

import dataobject.*;
import utils.Neo4jUtil;

import java.io.IOException;

public class CreateNodes {

    public static void creaateFoodDes() throws IOException {
        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        FoodDes.getAllFoodDesList().forEach(foodDes -> {
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

        neo4jUtil.close();
    }

    public static void createDataSrc() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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
    }

    public static void createDarsrcln() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        Datsrcln.getAllDatsrclnList().forEach(datsrcln -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Datsrcln { dataSrcId: \'" + datsrcln.getDataSrcId().trim() + "\', "
                            + "ndbNo: \'" + datsrcln.getNdbNo().trim() + "\', "
                            + "nutrNo: \'" + datsrcln.getNutrNo().trim().trim() + "\' })");
            System.out.println(datsrcln);
        });

    }

    public static void createDerivCd() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        DerivCd.getAllDerivCdList().forEach(derivCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:DerivCd { derivCd: \'" + derivCd.getDerivCd().trim() + "\', "
                            + "derivDesc: \'" + derivCd.getDerivDesc().trim()+ "\' })");
            System.out.println(derivCd);
        });
    }

    public static void createFdGroup() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        FdGroup.getAllFdGroupList().forEach(fdGroup -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:FdGroup { fdGrpCd: \'" + fdGroup.getFdGrpCd().trim() + "\', "
                            + "fdGrpDesc: \'" + fdGroup.getFdGrpDesc().trim() + "\' })");
            System.out.println(fdGroup);
        });
    }

    public static void createFootnote() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        Footnote.getAllFootnoteList().forEach(footnote -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Footnote { footntNo: \'" + footnote.getFootntNo().trim() + "\', "
                            + "ndbNo: \'" + footnote.getNdbNo().trim() + "\', "
                            + "footntTxt: \'" + footnote.getFootntTxt().trim() + "\', "
                            + "footntTyp: \'" + footnote.getFootntTyp().trim() + "\', "
                            + "nutrNo: \'" + footnote.getNutrNo().trim() + "\' })");
            System.out.println(footnote);
        });
    }

    public static void createLangdesc() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        Langdesc.getAllLangdescList().forEach(langdesc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langdesc { description: \'" + langdesc.getDescription().trim() + "\', "
                            + "factorCode: \'" + langdesc.getFactorCode().trim() + "\' })");
            System.out.println(langdesc);
        });
    }

    public static void createLangual() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        Langual.getAllLangualList().forEach(langual -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langual { factorCode: \'" + langual.getFactorCode().trim() + "\', "
                            + "ndbNo: \'" + langual.getNdbNo().trim() + "\' })");
            System.out.println(langual);
        });
    }

    public static void createNutData() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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
    }

    public static void createNutrDef() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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
    }

    public static void createSrcCd() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        SrcCd.getAllSrcCdList().forEach(srcCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:SrcCd { srcCd: \'" + srcCd.getSrcCd().trim() + "\', "
                            + "srcCdDesc: \'" + srcCd.getSrcCdDesc().trim() + "\' })");
            System.out.println(srcCd);
        });
    }

    public static void createWeight() throws IOException {

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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
        });
    }
}

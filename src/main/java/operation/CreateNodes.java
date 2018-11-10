package operation;

import dataobject.*;
import utils.Neo4jConfig;
import utils.Neo4jUtil;

import java.io.IOException;

public class CreateNodes {

    private Neo4jUtil neo4jUtil = new Neo4jConfig().getNeo4j();

    public CreateNodes() throws IOException {}

    public void creaateFoodDes() throws IOException {

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

    public void createDataSrc() throws IOException {

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

        neo4jUtil.close();
    }

    public void createDarsrcln() throws IOException {

        Datsrcln.getAllDatsrclnList().forEach(datsrcln -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Datsrcln { dataSrcId: \'" + datsrcln.getDataSrcId().trim() + "\', "
                            + "ndbNo: \'" + datsrcln.getNdbNo().trim() + "\', "
                            + "nutrNo: \'" + datsrcln.getNutrNo().trim().trim() + "\' })");
            System.out.println(datsrcln);
        });

        neo4jUtil.close();
    }

    public void createDerivCd() throws IOException {

        DerivCd.getAllDerivCdList().forEach(derivCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:DerivCd { derivCd: \'" + derivCd.getDerivCd().trim() + "\', "
                            + "derivDesc: \'" + derivCd.getDerivDesc().trim()+ "\' })");
            System.out.println(derivCd);
        });

        neo4jUtil.close();
    }

    public void createFdGroup() throws IOException {

        FdGroup.getAllFdGroupList().forEach(fdGroup -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:FdGroup { fdGrpCd: \'" + fdGroup.getFdGrpCd().trim() + "\', "
                            + "fdGrpDesc: \'" + fdGroup.getFdGrpDesc().trim() + "\' })");
            System.out.println(fdGroup);
        });

        neo4jUtil.close();
    }

    public void createFootnote() throws IOException {

        Footnote.getAllFootnoteList().forEach(footnote -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Footnote { footntNo: \'" + footnote.getFootntNo().trim() + "\', "
                            + "ndbNo: \'" + footnote.getNdbNo().trim() + "\', "
                            + "footntTxt: \'" + footnote.getFootntTxt().trim() + "\', "
                            + "footntTyp: \'" + footnote.getFootntTyp().trim() + "\', "
                            + "nutrNo: \'" + footnote.getNutrNo().trim() + "\' })");
            System.out.println(footnote);
        });

        neo4jUtil.close();
    }

    public void createLangdesc() throws IOException {

        Langdesc.getAllLangdescList().forEach(langdesc -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langdesc { description: \'" + langdesc.getDescription().trim() + "\', "
                            + "factorCode: \'" + langdesc.getFactorCode().trim() + "\' })");
            System.out.println(langdesc);
        });

        neo4jUtil.close();
    }

    public void createLangual() throws IOException {

        Langual.getAllLangualList().forEach(langual -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:Langual { factorCode: \'" + langual.getFactorCode().trim() + "\', "
                            + "ndbNo: \'" + langual.getNdbNo().trim() + "\' })");
            System.out.println(langual);
        });

        neo4jUtil.close();
    }

    public void createNutData() throws IOException {

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

        neo4jUtil.close();
    }

    public void createNutrDef() throws IOException {

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

        neo4jUtil.close();
    }

    public void createSrcCd() throws IOException {

        SrcCd.getAllSrcCdList().forEach(srcCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:SrcCd { srcCd: \'" + srcCd.getSrcCd().trim() + "\', "
                            + "srcCdDesc: \'" + srcCd.getSrcCdDesc().trim() + "\' })");
            System.out.println(srcCd);
        });

        neo4jUtil.close();
    }

    public void createWeight() throws IOException {

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

        neo4jUtil.close();
    }

    public void createDisease() throws IOException {

        DerivCd.getAllDerivCdList().forEach(derivCd -> {
            neo4jUtil.myNeo4j(
                    "CREATE (n:DerivCd { derivCd: \'" + derivCd.getDerivCd().trim() + "\', "
                            + "derivDesc: \'" + derivCd.getDerivDesc().trim()+ "\' })");
            System.out.println(derivCd);
        });

        neo4jUtil.close();
    }
}

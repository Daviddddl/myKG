import dataobject.*;

public class Help {

    public void printCommand(){
        FoodDes foodDes = new FoodDes("01","01", "Butter, salted", "BUTTER,WITH SALT",
                "KFC", "KFC", "human", "ffff", "Y", "chicken",
                "6,38", "4.27", "8.79", "3.86" );
        String foodDesCmd = "CREATE (n:FoodDes { ndbNo: \'" + foodDes.getNdbNo() + "\', "
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
                + "choFactor: \'" + foodDes.getChoFactor() + "\' })";
        System.out.println(foodDesCmd);

        DataSrc dataSrc = new DataSrc("01", "david", "test", "2018", "123",
                "singapore", "123", "003", "005");
        String dataSrcCmd = "CREATE (n:DataSrc { dataSrcId: \'" + dataSrc.getDataSrcId() + "\', "
                            + "authors: \'" + dataSrc.getAuthors() + "\', "
                            + "title: \'" + dataSrc.getTitle() + "\', "
                            + "year: \'" + dataSrc.getYear() + "\', "
                            + "journal: \'" + dataSrc.getJournal() + "\', "
                            + "volCity: \'" + dataSrc.getVolCity() + "\', "
                            + "issueState: \'" + dataSrc.getIssueState() + "\', "
                            + "startPage: \'" + dataSrc.getStartPage() + "\', "
                            + "endPage: \'" + dataSrc.getEndPage() + "\' })";
        System.out.println(dataSrcCmd);

        Datsrcln datsrcln = new Datsrcln("01", "01", "01");
        String datsrclnCmd = "CREATE (n:Datsrcln { dataSrcId: \'" + datsrcln.getDataSrcId() + "\', "
                            + "ndbNo: \'" + datsrcln.getNdbNo() + "\', "
                            + "nutrNo: \'" + datsrcln.getNutrNo() + "\' })";
        System.out.println(datsrclnCmd);

        DerivCd derivCd = new DerivCd("01", "01");
        String derivCdCmd = "CREATE (n:DerivCd { derivCd: \'" + derivCd.getDerivCd() + "\', "
                            + "derivDesc: \'" + derivCd.getDerivDesc() + "\' })";
        System.out.println(derivCdCmd);

        FdGroup fdGroup = new FdGroup("01, “01", "01");
        String fdGroupCmd = "CREATE (n:FdGroup { fdGrpCd: \'" + fdGroup.getFdGrpCd() + "\', "
                            + "fdGrpDesc: \'" + fdGroup.getFdGrpDesc() + "\' })";
        System.out.println(fdGroupCmd);

        Footnote footnote = new Footnote("01","01", "01", "01", "01");
        String footnoteCmd = "CREATE (n:Footnote { footntNo: \'" + footnote.getFootntNo() + "\', "
                            + "ndbNo: \'" + footnote.getNdbNo() + "\', "
                            + "footntTxt: \'" + footnote.getFootntTxt() + "\', "
                            + "footntTyp: \'" + footnote.getFootntTyp() + "\', "
                            + "nutrNo: \'" + footnote.getNutrNo() + "\' })";
        System.out.println(footnoteCmd);

        Langdesc langdesc = new Langdesc("01", "01");
        String langdescCmd = "CREATE (n:Langdesc { description: \'" + langdesc.getDescription() + "\', "
                            + "factorCode: \'" + langdesc.getFactorCode() + "\' })";
        System.out.println(langdescCmd);

        Langual langual = new Langual("01", "01");
        String langualCmd = "CREATE (n:Langual { factorCode: \'" + langual.getFactorCode() + "\', "
                            + "ndbNo: \'" + langual.getNdbNo() + "\' })";
        System.out.println(langualCmd);

        NutData nutData = new NutData("01", "01", "01", "01", "01", "01", "01", "01", "01"
                , "01", "01", "01", "01", "01", "01", "01", "01");
        String nuteDataCmd = "CREATE (n:NutData { addmodDate: \'" + nutData.getAddmodDate() + "\', "
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
                            + "upEb: \'" + nutData.getUpEb() + "\' })";
        System.out.println(nuteDataCmd);

        NutrDef nutrDef = new NutrDef("01", "01", "01", "01", "01", "01");
        String nutrDefCmd = "CREATE (n:NutrDef { numDec: \'" + nutrDef.getNumDec() + "\', "
                            + "nutrDesc: \'" + nutrDef.getNutrDesc() + "\', "
                            + "nutrNo: \'" + nutrDef.getNutrNo() + "\', "
                            + "srOrder: \'" + nutrDef.getSrOrder() + "\', "
                            + "tagName: \'" + nutrDef.getTagname() + "\', "
                            + "units: \'" + nutrDef.getUnits() + "\' })";
        System.out.println(nutrDefCmd);

        SrcCd srcCd = new SrcCd("01", "01");
        String srcCdCmd = "CREATE (n:SrcCd { srcCd: \'" + srcCd.getSrcCd() + "\', "
                            + "srcCdDesc: \'" + srcCd.getSrcCdDesc() + "\' })";
        System.out.println(srcCdCmd);

        Weight weight = new Weight("01", "01", "01", "01", "01", "01", "01");
        String weightCmd = "CREATE (n:Weight { amount: \'" + weight.getAmount() + "\', "
                            + "gmWgt: \'" + weight.getGmWgt() + "\', "
                            + "msreDesc: \'" + weight.getMsreDesc() + "\', "
                            + "ndbNo: \'" + weight.getNdbNo() + "\', "
                            + "numDataPts: \'" + weight.getNumDataPts() + "\', "
                            + "seq: \'" + weight.getSeq() + "\', "
                            + "getStdDev: \'" + weight.getStdDev() + "\' })";
        System.out.println(weightCmd);
    }


    public static void main(String[] args) {
        new Help().printCommand();
    }
}

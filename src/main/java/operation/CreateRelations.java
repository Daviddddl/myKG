package operation;

import dataobject.*;
import utils.Neo4jConfig;
import utils.Neo4jUtil;

import java.io.IOException;

public class CreateRelations {

    private Neo4jUtil neo4jUtil = new Neo4jConfig().getNeo4j();

    public CreateRelations() throws IOException {}

    // MATCH (a:Person),(b:Person) WHERE a.name = 'A' AND b.name = 'B' CREATE (a)-[r:RELTYPE]->(b) RETURN type(r)

    public void createFoodDes2FoodGroupDescription() throws IOException {
        /*
         * FoodDes -> FoodGroupDescription
         */

        FdGroup.getAllFdGroupList().forEach(fdGroup -> {
            String cmd = "MATCH (a:FoodDes),(b:FdGroup) WHERE a.fdGrpCd = '"
                    + fdGroup.getFdGrpCd().trim()
                    + "' AND b.fdGrpCd = '"
                    + fdGroup.getFdGrpCd().trim()
                    + "' CREATE (a)-[r:"
                    + "group"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }


    public void createFoodDes2Footnote() throws IOException {
        /*
         * FoodDes -> Footnote
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        FoodDes.getAllFoodDesList().forEach(foodDes -> {
            String cmd = "MATCH (a:FoodDes),(b:Footnote) WHERE a.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "footnote"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }

    public void createFoodDes2NutrientDateFile() throws IOException {
        /*
         * FoodDes -> Nutrient Date File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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

        neo4jUtil.close();
    }

    public void createFootnote2NutrientDateFile() throws IOException {
        /*
         * Footnote -> Nutrient Date File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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

        neo4jUtil.close();
    }

    public void createFoodDes2Weight() throws IOException {
        /*
         * FoodDes -> Weight File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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

        neo4jUtil.close();
    }

    public void createFoodDes22Langual() throws IOException {
        /*
         * FoodDes -> Langual
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

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
        });

        neo4jUtil.close();
    }

    public void createLangual2LangualFactorsDescriptionFile() throws IOException {
        /*
         * Langual -> Langual Factors Description File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        Langdesc.getAllLangdescList().forEach(langdesc -> {
            String cmd = "MATCH (a:Langual),(b:Langdesc) WHERE a.factorCode = '"
                    + langdesc.getFactorCode().trim()
                    + "' AND b.factorCode = '"
                    + langdesc.getFactorCode().trim()
                    + "' CREATE (a)-[r:"
                    + "lang_desc"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }

    public void createNutrientDataFile2NutrientDefinitionFile() throws IOException {
        /*
         * Nutrient Data File -> Nutrient Definition File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        NutrDef.getAllNutrDefList().forEach(nutrDef -> {
            String cmd = "MATCH (a:NutData),(b:NutrDef) WHERE a.nutrNo = '"
                    +  nutrDef.getNutrNo().trim()
                    + "' AND b.nutrNo = '"
                    + nutrDef.getNutrNo().trim()
                    + "' CREATE (a)-[r:"
                    + "nutr_def"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }

    public void createNutrientDataFile2SourceCodeFile() throws IOException {
        /*
         * Nutrient Data File -> Source Code File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        SrcCd.getAllSrcCdList().forEach(srcCd -> {
            String cmd = "MATCH (a:NutData),(b:SrcCd) WHERE a.srcCd = '"
                    +  srcCd.getSrcCd().trim()
                    + "' AND b.srcCd = '"
                    + srcCd.getSrcCd().trim()
                    + "' CREATE (a)-[r:"
                    + "src_code"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }

    public void createNutrientDataFile2DataDerivationCode() throws IOException {
        /*
         * Nutrient Data File -> Data Derivation Code
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        DerivCd.getAllDerivCdList().forEach(derivCd -> {
            String cmd = "MATCH (a:NutData),(b:DerivCd) WHERE a.derivCd = '"
                    +  derivCd.getDerivCd().trim()
                    + "' AND b.derivCd = '"
                    + derivCd.getDerivCd().trim()
                    + "' CREATE (a)-[r:"
                    + "data_derivation"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }

    public void createNutrientDataFile2SourcesofDataLinkFile() throws IOException {
        /*
         * Nutrient Data File -> Sources of Data Link File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        FoodDes.getAllFoodDesList().forEach(foodDes -> {
            String cmd = "MATCH (a:FoodDes),(b:Datsrcln) WHERE a.ndbNo = '"
                    +  foodDes.getNdbNo().trim()
                    + "' AND b.ndbNo = '"
                    + foodDes.getNdbNo().trim()
                    + "' CREATE (a)-[r:"
                    + "src_data_link"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }

    public void createSourcesofDataLinkFile2SourcesofDataFile() throws IOException {
        /*
         * Sources of Data Link File -> Sources of Data File
         */

        Neo4jUtil neo4jUtil = new Neo4jUtil("bolt://localhost:7687", "neo4j", "neo4jj" );

        DataSrc.getAllDataSrcList().forEach(dataSrc -> {
            String cmd = "MATCH (a:DataSrc),(b:Datsrcln) WHERE a.dataSrcId = '"
                    +  dataSrc.getDataSrcId().trim()
                    + "' AND b.dataSrcId = '"
                    + dataSrc.getDataSrcId().trim()
                    + "' CREATE (a)-[r:"
                    + "src_data_file"
                    +"]->(b) RETURN type(r)";
            neo4jUtil.myNeo4j(cmd);
            System.out.println(cmd);
        });

        neo4jUtil.close();
    }
}

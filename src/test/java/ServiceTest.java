import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.NodeService;

import java.io.IOException;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class ServiceTest {

    @Autowired
    NodeService nodeService;

    @Test
    public void TestNodes() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("title");
        arrayList.add("authors");
        System.out.println(nodeService.getNodesByLabels("DataSrc", 10, arrayList));
    }

    @Test
    public void TestRelations(){
        System.out.println(nodeService.getRelationsByName("group", 5));
    }

    @Test
    public void getNode(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("choFactor");
        arrayList.add("comName");
        arrayList.add("fatFactor");
        System.out.println(nodeService.getNodeById("957562", null));
    }
}

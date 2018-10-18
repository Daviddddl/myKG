package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.NodeService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Resource
    @Autowired
    NodeService nodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }



}

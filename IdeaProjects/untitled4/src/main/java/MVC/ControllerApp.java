package MVC;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ControllerApp {
    @RequestMapping("/")
    public String op(){
        return "index";
    }
}

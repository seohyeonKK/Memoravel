package study.memoravel.api;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags = {"TEST API"})
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}

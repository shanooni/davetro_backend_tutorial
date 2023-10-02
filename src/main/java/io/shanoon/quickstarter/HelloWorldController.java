package io.shanoon.quickstarter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path="/hello")
    public String greeting(){
        return "welcome Shanoon";
    }
}

package olegivanov.controller;

import olegivanov.service.WebService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    private final WebService webService;

    public WebController(WebService webService) {
        this.webService = webService;
    }

    @GetMapping("/")
    public String hello() {
        return "First Greatings";
    }

    @GetMapping("/products/fetch-product")
    @ResponseBody
    public List<String> getProductsByName(@RequestParam("name") String name) {
        return webService.getProductsByName(name);
    }




}

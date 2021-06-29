package pl.dg.opaws.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/")
    public String getProduct(){
        return "Product!";
    }
}

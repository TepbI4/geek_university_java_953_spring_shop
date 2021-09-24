package ru.gb.alekseiterentev.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.alekseiterentev.shop.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/create")
    public String showCreateProductPage() {
        return "create_product";
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam String name, @RequestParam Integer price) {
        productService.save(name, price);
        return "redirect:/product";
    }

    @GetMapping("/decrease/{id}")
    public String decreasePriseForProduct(@PathVariable Long id) {
        productService.decrease(id);
        return "redirect:/product";
    }

    @GetMapping("/increase/{id}")
    public String increasePriseForProduct(@PathVariable Long id) {
        productService.increase(id);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/product";
    }
}

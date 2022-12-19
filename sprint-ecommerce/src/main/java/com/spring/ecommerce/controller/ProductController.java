package com.spring.ecommerce.controller;

import com.spring.ecommerce.model.Product;
import com.spring.ecommerce.model.User;
import com.spring.ecommerce.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public String show(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/show";
    }

    @GetMapping("/create")
    public String create() {
        return "products/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        LOGGER.info("This its Object of product {} ", product);
        User user = new User(1, "", "", "", "", "", "", "");
        product.setUser(user);
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Product> productOptional = productService.get(id);
        Product product = productOptional.orElseGet(Product::new);
        model.addAttribute("product", product);
        LOGGER.info("{}", product);
        return "products/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        product.setUser(new User(1, "", "", "", "", "", "", ""));
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/products";
    }
}

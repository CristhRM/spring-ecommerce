package com.spring.ecommerce.controller;

import com.spring.ecommerce.model.Order;
import com.spring.ecommerce.model.OrderDetail;
import com.spring.ecommerce.model.Product;
import com.spring.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    List<OrderDetail> orderDetails = new ArrayList<>();

    Order order = new Order();

    @GetMapping
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "user/home";
    }

    @GetMapping("/home-product/{id}")
    public String homeProduct(@PathVariable Integer id, Model model) {
        Optional<Product> productOptional = productService.get(id);
        Product product = productOptional.orElseGet(Product::new);
        model.addAttribute("products", product);
        return "user/product_home";
    }

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer amount, Model model) {
        OrderDetail orderDetail = new OrderDetail();
        double totalSum = 0;

        productService.get(id).ifPresent(product -> {
            orderDetail.setAmount(amount);
            orderDetail.setPrice(product.getPrice());
            orderDetail.setName(product.getName());
            orderDetail.setTotal(product.getPrice() * amount);
            orderDetail.setProduct(product);
        });

        orderDetails.add(orderDetail);
        totalSum = orderDetails.stream().mapToDouble(OrderDetail::getTotal).sum();
        order.setTotal(totalSum);

        model.addAttribute("cart", orderDetails);
        model.addAttribute("order", order);

        return "user/car";
    }
}

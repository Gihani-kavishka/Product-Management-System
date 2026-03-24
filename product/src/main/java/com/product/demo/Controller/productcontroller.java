package com.product.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.product.demo.Entity.product;
import com.product.demo.Service.productservice;

@Controller
public class productcontroller {

    @Autowired
    private productservice service;

    // ✅ Home page
    @GetMapping({"/", "/home"})
    public String home() {
        return "home"; // looks for templates/home.html
    }

    // ✅ Product list page
    @GetMapping("/product")
    public String getAllproduct(Model model) {
        model.addAttribute("products", service.getAllproduct());
        return "product"; // templates/product.html
    }

    // ✅ Open create form
    @GetMapping("/product/new")
    public String createProductForm(Model model) {
        model.addAttribute("product", new product());
        return "create-product"; // templates/create-product.html
    }

    // ✅ Save product
    @PostMapping("/product")
    public String saveProduct(@ModelAttribute product product,
                              RedirectAttributes redirectAttributes) {
        service.saveProduct(product);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/product";
    }

    // ✅ Open edit form
    @GetMapping("/product/edit/{id}")
    public String editProductForm(@PathVariable int id, Model model) {
        model.addAttribute("product", service.getproductyId(id));
        return "edit_product"; // templates/edit_productt.html
    }

    // ✅ Update product
    @PostMapping("/product/edit/{id}")
    public String updateProduct(@PathVariable int id,
                                @ModelAttribute product product,
                                RedirectAttributes redirectAttributes) {

        product existing = service.getproductyId(id);
        existing.setProduct_Name(product.getProduct_Name());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());

        service.saveProduct(existing);
        redirectAttributes.addFlashAttribute("success", true);

        // ✅ FIXED redirect
        return "redirect:/product/edit/" + id;
    }

    // ✅ Delete product (clear URL)
    @GetMapping("/product/delete/{id}")
    public String deleteById(@PathVariable int id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteSuccess", true);
        return "redirect:/product";
    }
}

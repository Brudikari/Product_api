package payetonkawa.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payetonkawa.api.products.model.Product;
import payetonkawa.api.products.service.ProductService;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Crée un nouveau produit en base de données
     * @param product l'objet à créer
     * @return le produit enregistré
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    /**
     * Récupère un produit par son identifiant
     * @param id l'identifiant du produit
     * @return l'objet produit s'il existe, null sinon
     */
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") final Long id) {
        Optional<Product> product = productService.findProductById(id);
        System.out.println(product);
        return product.orElse(null);
    }

    /**
     * Récupère une liste de produits
     * @return une liste de produits
     */
    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        System.out.println(productService.getAllProducts());
        return productService.getAllProducts();
    }

    /**
     * Met à jour un produit
     * @param id l'identifiant du produit
     * @param product le produit qu'on veut mettre à jour
     * @return retourne l'objet product mis à jour
     */
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") final Long id, @RequestBody Product product) {

        Optional<Product> p = productService.findProductById(id);
        if (p.isPresent()) {
            Product currentProduct = p.get();

            String name = product.getName();
            if(name != null) {
                currentProduct.setName(name);
            }
            float price = product.getPrice();
            currentProduct.setPrice(price);

            String number = product.getProductNumber();
            if(number != null) {
                currentProduct.setProductNumber(number);
            }

            String description = product.getDescription();
            if(description != null) {
                currentProduct.setDescription(description);
            }

            int stock = product.getRemainingStock();
            currentProduct.setRemainingStock(stock);

            productService.saveProduct(currentProduct);
            return currentProduct;
        } else {
            return null;
        }
    }

    /**
     * Supprime un produit par son identifiant
     * @param id l'identifiant du produit
     */
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") final Long id) {
        productService.deleteProductById(id);
    }
}

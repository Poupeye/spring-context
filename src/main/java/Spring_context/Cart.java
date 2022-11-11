package Spring_context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class Cart {
    private ProductRepository productRepository;

    List<Product> productCart;

    @PostConstruct
    public void init() {
        productCart = new ArrayList<>();
    }

    public List<Product> getProductCart() {
        return productCart;
    }

    public void add(int id) {
        for (Product p : productRepository.getProducts()) {
            if (p.getId() == id);
            productCart.add(p);
        }
    }

    public void delete(int id) {
        for (Product p : productRepository.getProducts()) {
            if (p.getId() == id);
            productCart.remove(p);
        }
    }

}

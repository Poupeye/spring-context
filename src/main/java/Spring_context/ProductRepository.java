package Spring_context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "salo", 150));
        products.add(new Product(2, "Beer", 100));
        products.add(new Product(3, "pusy", 1500));
        products.add(new Product(4, "meet", 450));
        products.add(new Product(5, "water", 80));
    }

    public Product getById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}

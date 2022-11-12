package Spring_context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart = context.getBean("cart", Cart.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);


        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();
        int id = 0;
        if (cmd.equals("/add " + id)) {
            cart.add(id);
        } else if (cmd.equals("/delete" + id)) {
            cart.delete(id);
        } else if (cmd.equals("/cart")) {
            System.out.println(cart.getProductCart());
        } else if (cmd.equals("/price")) {
            System.out.println(productRepository.getProducts());
        }
        sc.nextLine();


        context.close();
    }
}
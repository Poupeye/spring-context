package Spring_context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart = context.getBean("cart", Cart.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);


        Scanner sc = new Scanner(System.in);

        while (true) {
            String cmd = sc.nextLine();

            if (cmd.startsWith("/add")) {
                String[] s = cmd.split(" ");
                int id = Integer.parseInt(s[1]);
                cart.add(id);
            } else if (cmd.startsWith("/delete")) {
                String[] s = cmd.split(" ");
                int id = Integer.parseInt(s[1]);
                cart.delete(id);
            } else if (cmd.equals("/cart")) {
                System.out.println(cart.getProductCart());
            } else if (cmd.equals("/price")) {
                System.out.println(productRepository.getProducts());
            } else if (cmd.equals("/q")) {
                return;
            }
        }
    }
}
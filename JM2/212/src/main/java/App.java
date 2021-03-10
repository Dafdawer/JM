import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld hw1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld hw2 =
                (HelloWorld) applicationContext.getBean("helloworld");
        Cat one = (Cat) applicationContext.getBean("cat");
        Cat two = (Cat) applicationContext.getBean("cat");

        System.out.println(hw1.getMessage());
        System.out.println(one.getName());

        System.out.println("Comparing, hw are the same: " + hw1.equals(hw2));
        System.out.println("Comparing, cats are the same: " + one.equals(two));

    }
}
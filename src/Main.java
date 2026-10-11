import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        OrderService service = new OrderService();

        Customer c1 = new Customer(
                1,
                "Анна Іваненко",
                "anna@gmail.com"
        );

        Customer c2 = new Customer(
                2,
                "Максим Петренко",
                "max@gmail.com"
        );

        Customer c3 = new Customer(
                3,
                "Олена Коваль",
                "olena@gmail.com"
        );

        Product p1 = new Product(
                1,
                "Ноутбук",
                ProductCategory.ELECTRONICS,
                35000
        );

        Product p2 = new Product(
                2,
                "Футболка",
                ProductCategory.CLOTHING,
                800
        );

        Product p3 = new Product(
                3,
                "Книга Java",
                ProductCategory.BOOKS,
                700
        );

        Product p4 = new Product(
                4,
                "Настільна лампа",
                ProductCategory.HOME,
                1200
        );

        Order o1 = new Order(
                1,
                c1,
                Arrays.asList(p1, p3),
                OrderStatus.NEW
        );

        Order o2 = new Order(
                2,
                c2,
                Arrays.asList(p2, p4),
                OrderStatus.PROCESSING
        );

        Order o3 = new Order(
                3,
                c1,
                Arrays.asList(p2, p3),
                OrderStatus.DELIVERED
        );

        Order o4 = new Order(
                4,
                c3,
                Arrays.asList(p1),
                OrderStatus.SHIPPED
        );

        Order o5 = new Order(
                5,
                c2,
                Arrays.asList(p3),
                OrderStatus.CANCELLED
        );

        service.addOrder(o1);
        service.addOrder(o2);
        service.addOrder(o3);
        service.addOrder(o4);
        service.addOrder(o5);

        System.out.println("=== ПОШУК ЗАМОВЛЕННЯ ЗА ID ===");
        System.out.println(service.findOrderById(1));

        System.out.println("\n=== ЗАМОВЛЕННЯ КЛІЄНТА 1 ===");
        System.out.println(service.findOrdersByCustomer(1));

        System.out.println("\n=== ЗАМОВЛЕННЯ ЗІ СТАТУСОМ NEW ===");
        System.out.println(service.findOrdersByStatus(OrderStatus.NEW));

        System.out.println("\n=== ЗАМОВЛЕННЯ З ТОВАРОМ ID 2 ===");
        System.out.println(service.findOrdersContainingProduct(2));

        System.out.println("\n=== СУМА ЗАМОВЛЕННЯ 1 ===");
        System.out.println(service.calculateOrderTotal(1) + " грн");

        System.out.println("\n=== КЛІЄНТИ, ЯКІ МАЮТЬ ЗАМОВЛЕННЯ ===");
        System.out.println(service.findCustomersWithOrders());

        System.out.println("\n=== СОРТУВАННЯ ЗАМОВЛЕНЬ ЗА СУМОЮ ===");

        for (Order order : service.sortOrdersByTotalPrice()) {
            System.out.println(
                    order + " | total=" +
                            service.calculateOrderTotal(order.getId()) +
                            " грн"
            );
        }

        System.out.println("\n=== КІЛЬКІСТЬ ЗАМОВЛЕНЬ ЗА СТАТУСАМИ ===");
        System.out.println(service.countOrdersByStatus());

        System.out.println("\n=== ВИДАЛЕННЯ ЗАМОВЛЕННЯ 2 ===");
        service.removeOrder(2);

        System.out.println(service.findOrderById(2));
    }
}
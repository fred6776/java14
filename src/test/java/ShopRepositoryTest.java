import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    void testRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(144, "Хлеб", 47);
        Product product2 = new Product(10, "Икра", 470);
        repo.add(product1);
        repo.add(product2);
        repo.remove(144);
        Product[] expected = new Product[]{product2};
        Product[] actual = repo.findAll();
        //repo.remove(product1.getId());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testRemoveNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(144, "Хлеб", 47);
        repo.add(product1);
        repo.remove(144);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(144);
        });
    }
}

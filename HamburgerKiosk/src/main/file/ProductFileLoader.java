package main.file;

import main.menu.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static main.file.validator.FileErrorMessage.*;

public class ProductFileLoader {

    private static final String FILE_PATH = "src/main/resources/products.md";

    public static List<String> load() {
        List<String> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.readLine(); // 헤더 생략
            String product;
            while ((product = br.readLine()) != null) {
                products.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(FAILED_READ_FILE.getMessage());
        }
        return products;
    }

    public static void save(List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("name, price, quantity, description, category\n"); // 헤더 추가
            for (Product product : products) {
                bw.write(product.toMDFormat() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(FAILED_WRITE_FILE.getMessage());
        }
    }

}
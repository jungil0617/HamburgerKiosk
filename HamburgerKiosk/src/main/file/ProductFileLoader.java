package main.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static main.file.validator.FileErrorMessage.FAILED_READ_FILE;

public class ProductFileLoader {

    private static final String FILE_PATH = "src/main/resources/products.md";

    public static List<String> load() {
        List<String> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String product;
            while ((product = br.readLine()) != null) {
                products.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(FAILED_READ_FILE.getMessage());
        }

        return products;
    }

}
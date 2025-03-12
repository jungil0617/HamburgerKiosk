package main.order.validator;

import main.menu.Product;
import main.menu.ProductService;

import static main.order.validator.OrderErrorMessage.*;

public class OrderValidator {

    public static void createValidator(String[] parts, ProductService productService) {
        validateFormat(parts);
        validateProductExists(parts[0], productService);
        validateQuantityFormat(parts[1], productService);
        validateQuantity(parts, productService);
    }

    private static void validateFormat(String[] parts) {
        if (parts.length != 2) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private static void validateQuantityFormat(String quantityInput, ProductService productService) {
        try {
            int quantity = Integer.parseInt(quantityInput.trim());
            if (quantity <= 0) {
                throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private static void validateProductExists(String productName, ProductService productService) {
        Product product = productService.getProductByName(productName);
        if (product == null) {
            throw new IllegalArgumentException(PRODUCT_NOT_FOUND.getMessage());
        }
    }

    private static void validateQuantity(String[] parts, ProductService productService) {
        Product product = productService.getProductByName(parts[0]);
        if (product.getQuantity() < Integer.parseInt(parts[1].trim())) {
            throw new IllegalArgumentException(INVALID_QUANTITY.getMessage());
        }
    }

}
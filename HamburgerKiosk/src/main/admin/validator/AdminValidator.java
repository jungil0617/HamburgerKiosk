package main.admin.validator;

import main.admin.Admin;
import java.util.List;

import static main.admin.validator.AdminErrorMessage.*;

public class AdminValidator {

    public static void createValidator(String[] adminData, List<Admin> admins) {
        validateLength(adminData);
        validateNumberFormat(adminData);
        validateIsNegative(adminData);
        validateDuplicateAdmin(adminData, admins);
    }

    private static void validateLength(String[] adminData) {
        if (adminData.length != 2) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateNumberFormat(String[] adminData) {
        try {
            Integer.parseInt(adminData[1].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        }
    }

    private static void validateIsNegative(String[] adminData) {
        if (Integer.parseInt(adminData[1].trim()) < 0) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    public static void validateDuplicateAdmin(String[] adminData, List<Admin> admins) {
        if (admins.stream().anyMatch(admin -> admin.getId().equals(adminData[0]))) {
            throw new IllegalArgumentException(DUPLICATE_ADMIN.getMessage());
        }
    }

}
package com.ust.project.sustainability.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(String supplierId) {
        super("SupplierGoals not found for Supplier ID: " + supplierId);
    }
}

package ru.javapro.tasksix.tasksix.dto;

/**
 * @author SDudin
 */
public class Product {
    private Long productId;
    private String accountNumber;
    private String balance;
    private ProductType productType;
    private Boolean resultOperation;

    public void setResultOperation(Boolean resultOperation) {
        this.resultOperation = resultOperation;
    }

    public Boolean getResultOperation() {
        return resultOperation;
    }

    public Product() {
    }

    public Product(Boolean resultOperation) {
        this.resultOperation = resultOperation;
    }

    public Product(Long productId, String accountNumber, String balance, ProductType productType) {
        this.productId = productId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance='" + balance + '\'' +
                ", productType=" + productType +
                '}';
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public ProductType getProductType() {
        return productType;
    }

}
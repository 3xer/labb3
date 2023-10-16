package org.example;

import entities.Category;
import entities.Product;
import entities.ProductRecord;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import service.Wearehouse;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class AppTest {
    @Test
    void test() {
        assertThat(true).isTrue();
    }
    Wearehouse wearehouse = new Wearehouse();
    private Product createProduct(){
        Product mockProduct = new Product(0,"name", Category.Medium, 5, LocalDateTime.now());
        Product mockProduct2 = new Product(1, "item", Category.Small, 10, LocalDateTime.now());
        wearehouse.addProduct(mockProduct);
        wearehouse.addProduct(mockProduct2);
        return mockProduct;

    }
    @Test
    void addAndGetProduct() {
        Product mockProduct = createProduct();
        assertEquals(mockProduct.getProductRecord(), wearehouse.getProduct(0));
    }
    @Test
    void getProductByCategory(){
        Product mockProduct = createProduct();
        assertEquals(mockProduct.getProductRecord(), wearehouse.getProductByCategory(Category.Medium).get(0));
        assertNotEquals(mockProduct.getProductRecord(), wearehouse.getProductByCategory(Category.Small).get(0));
    }
    @Test
    void getModified(){
        Product mockProduct = createProduct();
        assertEquals(mockProduct.isModified(), false);
        mockProduct.setName("newName");
        assertEquals(mockProduct.isModified(), true);

        assertEquals(wearehouse.getModified().get(0), mockProduct.getProductRecord());
        assertNotEquals(wearehouse.getModified().get(0), wearehouse.getProduct(1));
    }
    @Test
    void getCreated (){
        createProduct();
        assertEquals(wearehouse.getCreated(LocalDateTime.now().minusHours(1)).get(0), wearehouse.getProduct(0));
    }
    @Test
    void getAll(){
        createProduct();
        assertEquals(wearehouse.getAll().size(), 2);
        assertEquals(wearehouse.getAll().get(0), wearehouse.getProduct(0));
        assertEquals(wearehouse.getAll().get(1), wearehouse.getProduct(1));
    }
    @Test
    void getRating(){
        createProduct();
        assertEquals(wearehouse.getProduct(0).rating(), 5);
    }
    @Test
    void setId(){
        int mockId = 10;
        createProduct().setId(mockId);
        assertEquals(wearehouse.getProduct(mockId).id(), mockId);
    }
    @Test
    void setName(){
        String mockName = "mockname";
        createProduct().setName(mockName);
        assertEquals(wearehouse.getProduct(0).name(), mockName);
    }
    @Test
    void setCategory(){
        Category mockCategory = Category.Big;
        createProduct().setCategory(mockCategory);
        assertEquals(wearehouse.getProduct(0).category(), mockCategory );
    }
    @Test
    void setRating(){
        int mockRating = 1;
        createProduct().setRating(mockRating);
        assertEquals(wearehouse.getProduct(0).rating(), mockRating);
    }
    @Test
    void setTime(){
        LocalDateTime mockTime = LocalDateTime.now().minusHours(1);
        createProduct().setCreateTime(mockTime);
        assertEquals(wearehouse.getProduct(0).createTime(), mockTime);
    }


}
package service;

import entities.Category;
import entities.Product;
import entities.ProductRecord;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


public class Wearehouse {
    ArrayList<Product> productList = new ArrayList<Product>();

    //constructor
    public Wearehouse(){

    }
    public Product addProduct(Product p){
        if(p.hasName()){
            productList.add(p);
            System.out.println(p.getName()+ "\nproduct added ");
            return p;
        }
        else{
            System.out.println("product has no name");
            return null;
        }

    }
    public ProductRecord getProduct (int id) throws NoSuchElementException{
       return productList.stream().filter(p -> p.getId() == id).findFirst().get().getProductRecord();
    }
    public List<ProductRecord> getProductByCategory (Category category){
        return productList.stream().filter(p -> p.getCategory() ==category).sorted(
                Comparator.comparing(Product::getCategory)).map(Product::getProductRecord).toList();
    }
    public List<ProductRecord> getModified (){
        return productList.stream().filter(Product::isModified).map(Product::getProductRecord).toList();
    }
    public List<ProductRecord> getCreated (LocalDateTime time){
        return productList.stream().filter(p -> p.getCreateTime().isAfter(time)).map(Product::getProductRecord).toList();
    }
    public List<ProductRecord> getAll (){
        return productList.stream().map(Product::getProductRecord).toList();
    }

}

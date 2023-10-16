package entities;

import java.time.LocalDateTime;

public class Product {
    private  int id;
    private  String name;
    private Category category;
    private int rating;
    private LocalDateTime createTime;
    private LocalDateTime latestModified;
    //constructor
    public Product(int id, String name, Category category ,int rating ,LocalDateTime createTime){
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.createTime = createTime;
        this.latestModified = createTime;
    }
    //---getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Category getCategory() {
        return category;
    }
    public int getRating() {
        return rating;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    //---setters
    public void setId (int id){
        this.id = id;
        latestModified = LocalDateTime.now();
    }
    public void setName (String name){
        this.name = name;
        latestModified = LocalDateTime.now();
    }
    public void setCategory (Category category){
        this.category = category ;
        latestModified = LocalDateTime.now();
    }
    public void setRating (int rating){
        this.rating = rating ;
        latestModified = LocalDateTime.now();
    }
    public void setCreateTime(LocalDateTime createTime){
        this.createTime = createTime;
        latestModified = LocalDateTime.now();
    }

    public boolean isModified(){
        return !createTime.equals(latestModified);
    }

    public boolean hasName (){
        return !name.isEmpty();
    }
    public ProductRecord getProductRecord (){
        return new ProductRecord(id, name, category ,rating,createTime);
    }

}

package com.example.Pet_Adoption_System.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
@Document(collection = "pets")
public class Pet {
    @Id
    private String id;
    private String species;
    private String name;
    private String breed;
    private String sex;
    private String age;
    private String color;
    private String location;
    private String contactNo;
    private String description;

    public String getBirthdate() {
        return description;
    }

    public void setBirthdate(String birthdate) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String imageUrl;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getArrivedFrom() {
        return location;
    }


    public String getColor() {
        return color;
    }

    public String getSex() {
        return sex;
    }


    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void setArrivedFrom(String arrivedFrom) {
        this.location = location;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}


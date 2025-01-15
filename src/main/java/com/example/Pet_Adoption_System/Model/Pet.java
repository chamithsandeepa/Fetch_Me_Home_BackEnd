package com.example.Pet_Adoption_System.Model;

<<<<<<< HEAD
import java.util.List;

=======
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
>>>>>>> main
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
=======
>>>>>>> main

@Data
<<<<<<< HEAD
@Getter
@NoArgsConstructor
@Setter
=======
@Builder
@Document(collection = "pets")
>>>>>>> main
public class Pet {
    @Id
    private String id;
    private String species;
    private String name;
    private String breed;
    private String sex;
<<<<<<< HEAD
    private boolean adopted = false; //default: false
=======
    private String age;
    private String color;
    private String location;
    private String contactNo;
>>>>>>> main
    private String description;
    private String imageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}



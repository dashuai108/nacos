package com.example.provider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Test")
public class Test implements Serializable {
    private static final long serialVersionUID = 8990412930408042769L;
    private String id;
    private String age;
    private String name;


    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id ;
    }



    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age){
        this.age = age ;
    }



    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name ;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.gmail.at.kotamadeo.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull(message = "Фамилия не может быть пустой!")
    @Size(min = 3, max = 30, message = "Фамилия должна содержать от 3 до 30 символов!")
    private String surname;

    @Column
    @NotNull(message = "Имя не может быть пустым!")
    @Size(min = 3, max = 30, message = "Имя должно содержать от 3 до 30 символов!")
    private String name;

    @Column
    @NotNull(message = "Пол не может быть пустым!")
    @Size(min = 1, max = 6, message = "обозначение пола должно быть 1 символом!")
    private String sex;

    @Column
    @Email(message = "Email должен быть валидным!")
    private String email;

    @Column
    @Min(message = "Возраст не может быть отрицательным!", value = 0)
    @NotNull(message = "Возраст не может быть пустым!")
    private byte age;

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }
}

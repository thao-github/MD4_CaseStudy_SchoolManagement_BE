package com.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max=50)
    @Email
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(min=6, max=100)
    private String password;

    @Lob
    private String avatar;

    @Lob
    private String phone;

    @Lob
    private String address;

    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
    joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    @ManyToOne
    private Classes classes;

    public User() {
    }

    public User(@NotBlank @Size(min = 3, max = 50) String  name,
                @NotBlank @Size(min = 3, max = 50) String username,
                @NotBlank @Size(max=50) @Email String email,
                String avatar,
                @NotBlank @Size(min=6, max=100)String encode) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.password = encode;
    }

    public User(Long id, String name, String username, String email, String password, String avatar, String phone, String address, String status, Set<Role> roles, Classes classes) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.roles = roles;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}

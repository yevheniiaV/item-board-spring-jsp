package entity;

import entity.FieldEqualsAnnotation.FieldEquals;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@FieldEquals(field = "pass", equalsTo = "pass2")
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    private int id;

    @Email
    @Size(min = 5, message = "Must be at least 5 characters!")
    private String email;

    @NotNull
    @Size(min = 2, max = 24, message = "Must be at least 2 characters!")
    private String name;

    @NotNull
    @Size(min = 6, message = "Must be at least 6 characters!")
    private String pass;

    @Transient
    @NotNull
    @Size(min = 6, message = "Must be at least 6 characters!")
    private String pass2;

    @NotNull
    @Size(min = 8, message = "Must be at least 8 characters!")
    private String phone;

    @NotNull
    @Size(min = 2, max = 14, message = "Must be at least 2 characters!")
    private String city;

    public User() {
    }

    public User(String email, String name, String pass, String phone, String city) {
        this.name = name;
        this.pass = pass;
        this.phone = phone;
        this.email = email;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.pass);
        hash = 29 * hash + Objects.hashCode(this.phone);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name  + ", pass=" + pass + ", phone=" + phone + ", email=" + email + ", city=" + city + '}';
    }

}

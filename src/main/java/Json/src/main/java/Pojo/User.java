package Pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @JsonProperty(“name”) — эта говорит, что данный атрибут в JSON будет именоваться как name
 * @JsonIgnore — а эта аннотация игнорирует данный атрибут и в результате конвертирования он не будет добавлен в JSON.
 */
public class User {
    @JsonProperty("Number")
    private long id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Phone number")
    private String phone;
    @JsonIgnore
    private String level;

    public User() {
    }

    public User(long id, String name, String phone, String level) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

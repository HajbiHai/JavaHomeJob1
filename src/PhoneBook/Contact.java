package PhoneBook;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable {
    //class attributes
    String name;
    String phone;

    //constructor
    Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
//get attributes methods
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

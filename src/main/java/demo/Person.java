package demo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class Person {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty number;
    private final SimpleListProperty<String> fruits;

    Person(String name, Integer number, List<String> fruits) {
        this.name = new SimpleStringProperty(name);
        this.number = new SimpleIntegerProperty(number);
        this.fruits = new SimpleListProperty<>(observableArrayList(fruits));
    }

    public String getName() {
        return this.name.get();
    }

    public int getNumber() {
        return number.get();
    }

    public String getFruits() {
        return StringUtils.join(fruits.get(), ", ");
    }

}

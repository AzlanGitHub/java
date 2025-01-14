package org.javafx.javafxml.propertiesbind;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person
{

    private final
    StringProperty name = new SimpleStringProperty(this, "name", "");

    // Comment for Commit, Push und Pull. Get IT
    public StringProperty nameProperty(){
        return  name;
    }
    public String getName()
    {
        return name.get();
    }


    public void setName(String name)
    {
        this.name.set(name);
    }
}

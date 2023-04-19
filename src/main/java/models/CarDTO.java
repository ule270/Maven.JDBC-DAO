package models;

public class CarDTO implements ICarDTO {
    Integer id;
    String make;
    String model;
    String color;
    Integer year;
    String vin;

    public CarDTO() {
    }

    public CarDTO(Integer id, String make, String model, String color, Integer year, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.vin = vin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarDTO id(Integer id) {
        setId(id);
        return this;
    }

    public CarDTO make(String make) {
        setMake(make);
        return this;
    }

    public CarDTO model(String model) {
        setModel(model);
        return this;
    }

    public CarDTO color(String color) {
        setColor(color);
        return this;
    }

    public CarDTO year(Integer year) {
        setYear(year);
        return this;
    }

    public CarDTO vin(String vin) {
        setVin(vin);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", make='" + getMake() + "'" +
                ", model='" + getModel() + "'" +
                ", color='" + getColor() + "'" +
                ", year='" + getYear() + "'" +
                ", vin='" + getVin() + "'" +
                "}";
    }

    @Override
    public int getId() {
        return this.id;
    }

}

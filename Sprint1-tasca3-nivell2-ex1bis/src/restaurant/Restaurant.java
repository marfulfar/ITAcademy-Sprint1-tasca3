package restaurant;

import java.util.Objects;

public class Restaurant {

    private String name;
    private Integer rate;

    public Restaurant(String name, Integer rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return name.equals(that.name) && rate.equals(that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate);
    }
}//closes class

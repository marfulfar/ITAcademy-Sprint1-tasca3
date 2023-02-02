package month;

import java.util.Objects;

public class Month {

    private final String monthName;

    public Month(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthName='" + monthName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return monthName.equals(month.monthName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthName);
    }

}//closes class

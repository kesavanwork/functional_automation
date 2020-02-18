package domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class HotelBooking {
    private final String firstName;
    private final String lastName;
    private final BigDecimal price;
    private final String deposit;
    private final String checkin;
    private final String checkout;

    public HotelBooking(String firstName,
                        String lastName,
                        BigDecimal price,
                        String deposit,
                        String checkin,
                        String checkout) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.price = price;
        this.deposit = deposit;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDeposit() {
        return deposit;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof HotelBooking)) return false;

        HotelBooking that = (HotelBooking) o;

        return new EqualsBuilder()
            .append(firstName, that.firstName)
            .append(lastName, that.lastName)
            .append(price, that.price)
            .append(deposit, that.deposit)
            .append(checkin, that.checkin)
            .append(checkout, that.checkout)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(firstName)
            .append(lastName)
            .append(price)
            .append(deposit)
            .append(checkin)
            .append(checkout)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("firstName", firstName)
            .append("lastName", lastName)
            .append("price", price)
            .append("deposit", deposit)
            .append("checkin", checkin)
            .append("checkout", checkout)
            .toString();
    }
}


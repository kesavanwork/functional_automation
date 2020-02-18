package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.HotelBooking;
import org.openqa.selenium.WebDriver;
import pages.BookingPage;
import utils.ConfigurationLoader;
import utils.WebDriverBuilder;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Bookings {
    private static Map<String,String> config =  ConfigurationLoader.config();
    private static final String URL = config.get("appUrl");
    private WebDriver driver;
    private BookingPage bookingPage;
    HotelBooking hotelBooking;

    public Bookings() {
        this.driver = WebDriverBuilder.getDriver();
        this.bookingPage = new BookingPage(driver);
    }

    @Given("^Customer is on the hotel booking page$")
    public void customerIsOnTheHotelBookingPage() {
        System.out.println("string url is " + URL);
        driver.get(URL);
    }

    @When("^Customer enter the details and click Save$")
    public void customerEnterTheDetailsAndClickSave(DataTable table) {
        Map<String, String> bookingDataInMap = table.asMap(String.class, String.class);
        hotelBooking = new HotelBooking(
                bookingDataInMap.get("firstName"),
                bookingDataInMap.get("lastName"),
                new BigDecimal(bookingDataInMap.get("price")),
                bookingDataInMap.get("deposit"),
                bookingDataInMap.get("checkin"),
                bookingDataInMap.get("checkout"));
        bookingPage.enterBookingDetailsAndSave(hotelBooking);
    }

    @Then("^Customer should be able to add a new booking")
    public void customerShoudBeAbleToAddANewBooking() {
        assertThat(bookingPage.getAllTheBookings()).contains(hotelBooking);
    }

    @When("^I delete my booking$")
    public void iDeleteMyBooking() {
        bookingPage.deleteBooking(hotelBooking);
    }


    @Then("^My booking is deleted$")
    public void myBookingIsDeleted() {
        assertThat(bookingPage.getAllTheBookings()).doesNotContain(hotelBooking);
    }

}

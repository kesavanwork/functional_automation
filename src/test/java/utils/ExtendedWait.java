package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.function.Function;


public class ExtendedWait extends WebDriverWait {

    public ExtendedWait(WebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    public void forNewBookingToAppear(final int initialBookingCount) {

        until(new Function<WebDriver,Boolean>() {
            @Nullable
            public Boolean apply(@Nullable WebDriver driver) {
                return driver.findElements(By.cssSelector("#bookings>.row")).size() == initialBookingCount + 1;
            }
        });
    }

    public void forDeletedBookingToDisappear(final int initialBookingCount) {
        forNewBookingToAppear(initialBookingCount - 2);
    }
}

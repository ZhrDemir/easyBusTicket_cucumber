package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;


public class EasyBusTicket_stepdefinitions {
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String istenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));
    }

    @Then("Admin olarak giris yapar")
    public void admin_olarak_giris_yapar() {

        adminLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("admin20"));
        adminLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPass"));
        adminLoginPage.loginButton.click();
    }

    @Then("Booking_History linkinin görünürlügü test edilir")
    public void linkinin_görünürlügü_test_edilir() {

        Assert.assertTrue(adminDashBoardPage.bookingHistoryButton.isDisplayed());
    }

    @Then("Booking_History linkine tiklanir")
    public void linkine_tiklanir() {
        adminDashBoardPage.bookingHistoryButton.click();
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @And("{int} saniye bekle")
    public void saniyeBekle(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

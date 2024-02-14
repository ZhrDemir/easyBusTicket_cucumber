package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert.*;
import org.openqa.selenium.interactions.Actions;
import pages.admin.AdminDashBoardPage;
import pages.admin.AdminDashBoard_HeaderPage;
import pages.admin.AdminLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EasyBusTicket_stepdefinitions {
    AdminLoginPage adminLoginPage = new AdminLoginPage();
    AdminDashBoardPage adminDashBoardPage = new AdminDashBoardPage();
    AdminDashBoard_HeaderPage adminDashBoard_headerPage = new AdminDashBoard_HeaderPage();
    Actions actions = new Actions(Driver.getDriver());
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

        assertTrue(adminDashBoardPage.bookingHistoryButton.isDisplayed());
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

    //-----------US 33 TC2-----------------

    @Then("Search Butonu linkinin görünürlügü test edilir")
    public void search_butonu_linkinin_görünürlügü_test_edilir() {
        assertTrue(adminDashBoard_headerPage.buttonHeaderSearch.isDisplayed());
    }
    @Then("Search Butonu linkinin aktif olduğu test edilir")
    public void search_butonu_linkinin_aktif_olduğu_test_edilir() {
        assertTrue(adminDashBoard_headerPage.buttonHeaderSearch.isEnabled());
    }
    @Then("Search Butonu linkine tiklanir")
    public void search_butonu_linkine_tiklanir() {
       adminDashBoard_headerPage.buttonHeaderSearch.click();
    }
    @Then("Search Placeholder görünürlügü test edilir")
    public void search_placeholder_görünürlügü_test_edilir() {
      assertTrue(adminDashBoard_headerPage.navbarSearchField.isDisplayed());
    }
    @Then("Search Placeholder ına yazılan sayfaya gittigi dogrulanir")
    public void search_placeholder_ına_yazılan_sayfaya_gittigi_dogrulanir() {
        adminDashBoard_headerPage.navbarSearchField.click();

        actions.sendKeys("booked ticket").perform();
        actions.moveToElement(adminDashBoard_headerPage.labelSearchBookedTicket)
                .doubleClick(adminDashBoard_headerPage.labelSearchBookedTicket)
                .perform();

        String expectedUrl = "https://qa.easybusticket.com/admin/ticket/booked";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(expectedUrl,actualUrl);
        System.out.println(expectedUrl);
        System.out.println(actualUrl);




    }


}

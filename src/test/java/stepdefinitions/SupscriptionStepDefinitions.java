package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.HomePage;

public class SupscriptionStepDefinitions {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @Given("I open website {string}")
    public void iOpenWebsite(String url) {
        driver.get(url);
        homePage = new HomePage(driver);
    }

    @And("I change language to English")
    public void iChangeLanguageToEnglish() {
        homePage.changeLanguageToEnglish();
    }

    @Given("I open countries menu")
    public void iOpenCountriesMenu() {
        homePage.openCountriesMenu();
    }


    @When("I choose {string} country")
    public void iChooseCountry(String countryName) {
        homePage.chooseCountry(countryName);
    }

    @Then("I check mobile subscription is {string}")
    public void iCheckMobileSubscriptionIs(String status) {
        if (status.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue("Error: The selected country does not have mobile subscription plan",
                    homePage.doesCountryHaveMobileSubscription());
        } else if (status.equalsIgnoreCase("Disabled")) {
            Assert.assertFalse("Error: The selected country has mobile subscription plan",
                    homePage.doesCountryHaveMobileSubscription());
        } else {
            throw new IllegalArgumentException("can not identify mobile subscription status: " + status);
        }
    }

    @And("I check types {string} are displayed")
    public void iCheckTypesAreDisplayed(String planTypes) {
        String[] planTypesAsArray = planTypes.split(",");
        for (int i = 0; i < planTypesAsArray.length; i++) {
            Assert.assertEquals("Error: the displayed subscription plans are not correct",
                    planTypesAsArray[i], homePage.getSubscriptionPackageWithIndex(i));
        }
    }

    @And("I check the price is {string}")
    public void iCheckThePriceIs(String price) {
        Assert.assertTrue("displayed price is not correct",
                homePage.getPrice().contains(price));
    }

    @And("I check the currency is {string}")
    public void iCheckTheCurrencyIs(String currency) {
        Assert.assertTrue("The displayed currency is not correct",
                homePage.getPrice().contains(currency));
    }
}

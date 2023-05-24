package pageobjects;

import driveractions.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final DriverClass driverClass;

    public HomePage(WebDriver driver) {
        driverClass = new DriverClass(driver);
    }

    private final By languageButton = By.id("translation-btn");
    private final By countryButton = By.cssSelector("[class='country-current']");
    private final By COUNTRY_EGYPT = By.id("eg");
    private final By COUNTRY_UAE = By.id("ae");
    private final By COUNTRY_ALGERIA = By.id("dz");
    private final By COUNTRY_DJIBOUTI = By.id("dj");
    private final By COUNTRY_CHAD = By.id("td");
    private final By COUNTRY_IRAQ = By.id("iq");
    private final By COUNTRY_JORDAN = By.id("jo");
    private final By COUNTRY_LEBANON = By.id("lb");
    private final By COUNTRY_MOROCCO = By.id("ma");
    private final By COUNTRY_OMAN = By.id("om");
    private final By COUNTRY_TUNISIA = By.id("tn");
    private final By COUNTRY_YEMEN = By.id("ye");
    private final By COUNTRY_PALESTINE = By.id("ps");

    private final By MOBILE_SUBSCRIPTION_PANEL = By.cssSelector("[class='giftcard small trial-card']");

    private final By SUBSCRIPTION_PLAN = By.cssSelector("[class='plan-title']");

    private final By MONTHLY_PRICE = By.cssSelector("[id='currency-lite']");
    private final By WEEKLY_PRICE = By.xpath("//div[@class='trial-cost' and not(@id)]");

    private boolean mobileSubscription;


    public void changeLanguageToEnglish() {
        driverClass.click(languageButton);
    }

    public void openCountriesMenu() {
        driverClass.click(countryButton);
    }

    public void chooseCountry(String countryName) {
        switch (countryName) {
            case "Egypt":
                driverClass.click(COUNTRY_EGYPT);
                break;
            case "Uae":
                driverClass.click(COUNTRY_UAE);
                break;
            case "Algeria":
                driverClass.click(COUNTRY_ALGERIA);
                break;
            case "Djibouti":
                driverClass.click(COUNTRY_DJIBOUTI);
                break;
            case "Chad":
                driverClass.click(COUNTRY_CHAD);
                break;
            case "Iraq":
                driverClass.click(COUNTRY_IRAQ);
                break;
            case "Jordan":
                driverClass.click(COUNTRY_JORDAN);
                break;
            case "Lebanon":
                driverClass.click(COUNTRY_LEBANON);
                break;
            case "Morocco":
                driverClass.click(COUNTRY_MOROCCO);
                break;
            case "Oman":
                driverClass.click(COUNTRY_OMAN);
                break;
            case "Tunisia":
                driverClass.click(COUNTRY_TUNISIA);
                break;
            case "Yemen":
                driverClass.click(COUNTRY_YEMEN);
                break;
            case "Palestine":
                driverClass.click(COUNTRY_PALESTINE);
                break;
            default:
                throw new IllegalArgumentException("can not identify country: " + countryName);
        }
    }

    public boolean doesCountryHaveMobileSubscription() {
        mobileSubscription = driverClass.isVisible(MOBILE_SUBSCRIPTION_PANEL);
        return mobileSubscription;
    }

    public String getSubscriptionPackageWithIndex(int index) {
        return driverClass.getTextForElementWithIndex(SUBSCRIPTION_PLAN, index);
    }

    public String getPrice() {
        if (mobileSubscription) {
            return driverClass.getText(WEEKLY_PRICE);
        } else {
            return driverClass.getText(MONTHLY_PRICE);
        }
    }
}

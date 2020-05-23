package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.HashMap;
import java.util.List;


public class HomePage extends BasePage {

    public AppiumDriver driver;

    @FindBy(linkText = "Table")
    WebElement tableLink;

    @FindBy(linkText = "Table Filter")
    WebElement tableFilterLink;

    @FindBy(xpath = "//h3[text()='Tasks']")
    WebElement tasksSection;

    @FindBy(id = "task-table-filter")
    WebElement filter;

    @FindBy(xpath = "//table[@id='task-table']//tbody//tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id='task-table']//tbody//tr[contains(@style,'table-row')]")
    List<WebElement> tableRows2;

    @FindBy(xpath = "//table[@id='task-table']//tbody//tr[@style='display: table-row']")
    List<WebElement> tableRows3;

    @FindBy(xpath = "(//td[contains(text(),'progress')])[1]")
    WebElement statusInProgress;

    @FindBy(xpath = "(//td[contains(text(),'completed')])[1]")
    WebElement statusCompleted;

    @FindBy(xpath = "(//td[contains(text(),'failed qa')])[1]")
    WebElement statusFailedQA;

    @FindBy(xpath = "(//td[contains(text(),'deployed')])[1]")
    WebElement statusDeployed;

    public HomePage(AppiumDriver driver) {

        this.driver = driver;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(driver, this);

    }

    public HomePage navigateToTableFilter(){
        tableLink.click();
        tableFilterLink.click();
        return this;
    }

    public HomePage scrollToTasks(){
        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(new Point(100,500))).moveTo(PointOption.point(new Point(100,100))).release().perform();
        return this;
    }

    public HomePage setFilter(String searchKeyword) {
        filter.clear();
        filter.sendKeys(searchKeyword);
        return  this;
    }

    public int getNumberOfResults() {
        int i = 0;
        for(WebElement tableRow : tableRows){
            String display = tableRow.getCssValue("display");
            if(!display.equalsIgnoreCase("none")){
                i = i+1;
            }
        }
        return i;
    }


}
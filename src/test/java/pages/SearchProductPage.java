package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class SearchProductPage {

    @FindBy(xpath = "/html/body/header/div/div/div[1]/div/ul[2]/li[1]/button")
    WebElement clicksearchbutton;
    @FindBy(id = "searchInput")
    WebElement searchInput;
    @FindBy(className = "search__submit")
    WebElement submitsearch;
    @FindBy(className = "product-item__title")
    List<WebElement> product;
    @FindBy(className = "product-details__title")
    WebElement nameofproduct;
    @FindBy(id = "makeup")
    WebElement makeupbutton ;
    @FindBy(xpath = "//*[@id=\"main-navigation\"]/ul[2]/li[3]/div/div/div[2]/div[4]/div[2]/ul/li[1]/a")
    WebElement Lipstickbutton ;
    @FindBy(className = "product__content")
    List<WebElement> listofproduct;
    @FindBy(className = "js-filters-total-results")
    WebElement totalproduct;
    @FindBy(className = "product-details__price")
    WebElement priceofproduct;
    @FindBy(id = "pos-cnc-btn")
    WebElement addtobugbtn;
    @FindBy(xpath = "/html/body/div[13]/div/div[1]/button")
    WebElement closecart;
    @FindBy(xpath = "/html/body/header/div/div/div[1]/div/ul[2]/li[4]/button")
    WebElement cartbtn;
    @FindBy(tagName = "option")
    List<WebElement> quantity;
    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div/div[2]/div/table/tbody/tr[4]/td")
    WebElement totalprice;

    WebDriver driver;
    static String nameP ;
    static String message;
    static String searchproduct;
    static String Price;

    public SearchProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Clicksearchbutton(){
        this.clicksearchbutton.click();

    }
    public void setSearchInput(String arg){

        this.searchInput.sendKeys(arg);
        this.submitsearch.click();
        searchproduct=arg.toLowerCase(Locale.ROOT);
    }
    public void listeofproduct(){
        int count = product.size();
        for (int i = 0; i < count; i++) {
  			String P = product.get(i).getText().toLowerCase(Locale.ROOT);
            Assert.assertTrue("Product not exist in this liste", P.contains(searchproduct));
        }
    }
    public void savenameofproduct(){
         nameP = product.get(1).getText().toLowerCase(Locale.ROOT);

    }
    public void clicktosecondeproduct(){

        this.product.get(1).click();

    }
    public void getnameofproduct() {
         message = (nameofproduct).getText().toLowerCase(Locale.ROOT);
    }

    public void verifynameofproduit(){
        System.out.println(message);
        System.out.println(nameP);

        Assert.assertTrue("product name not equal", message.equals(nameP));

    }

    public void clicktomakeupbutton()  {

        this.makeupbutton.click();
    }
    public void clicktoLipstickbutton(){
        this.Lipstickbutton.click();
    }
    public void clicktorougeallure(){
        for (WebElement element: listofproduct){
                WebElement producttitle = element.findElement(By.className("txt-product__title"));
            System.out.println( "liste de produit " + producttitle.getText());
            if (producttitle.getText().toUpperCase().equals("ROUGE ALLURE")){
                element.click();
                return;

            }
        }
    }

    public void addproducttocart(){
        Price =priceofproduct.getText()+".00";
        System.out.println("Price"+ Price);
        this.addtobugbtn.click();


    }
    public void verifybagcart() throws InterruptedException {
        this.closecart.click();
        Thread.sleep(3000);
        this.cartbtn.click();
        Assert.assertTrue(quantity.get(0).getText().equals("1"));
        Assert.assertTrue(totalprice.getText().endsWith(Price));

    }

}

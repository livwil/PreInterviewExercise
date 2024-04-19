package com.preinterview.preinterviewexercise;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class StepsDef {

    @Given("^the user navigates to the login page$")
    public void theUserNavigatesToTheLoginPage() {
        Configuration.browser = "firefox";
        open("https://www.saucedemo.com/");
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials()  {
        LoginPage.usernameInput.sendKeys("standard_user");
        LoginPage.passwordInput.sendKeys("secret_sauce");
        LoginPage.loginButton.click();


    }

    @Then("the login should be successful")
    public void theLoginShouldBeSuccessful() {
        assertEquals(ProductPage.pageTitle.text(), "Products");
        ProductPage.shoppingCartButton.shouldBe(visible);

    }


    @And("the user identifies the highest-priced item and add that item to the shopping cart")
    public void theUserIdentifiesTheHighestPricedItemAndAddThatItemToTheShoppingCart()  {

        Double highestPrice = 0.0;
        SelenideElement highestAddToCartBtn = null;
        for(SelenideElement pricebar : $$(".pricebar")){
            double price =  Double.parseDouble(pricebar.find(".inventory_item_price").text().substring(1));
            if(price > highestPrice){
                highestPrice = price;
                highestAddToCartBtn = pricebar.find(".btn_inventory");
            }
        }
        assertNotNull(highestAddToCartBtn);
        assertEquals(highestPrice,49.99);
        highestAddToCartBtn.click();

    }

    @Then("the item should be successfully added to the cart")
    public void theItemShouldBeSuccessfullyAddedToTheCart() {
        ProductPage.shoppingCartButton.click();
        assertEquals(CheckoutPage.checkoutPageTitle.text(), "Your Cart");
        assertEquals(CheckoutPage.checkoutButton.text(), "Checkout");
        CheckoutPage.checkoutButton.should(visible);

    }

}

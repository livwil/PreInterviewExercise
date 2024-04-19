package com.preinterview.preinterviewexercise;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$x;

/**
 * This is the checkout page class with 2 parameter for assertion purpose only
 *
 */
public class CheckoutPage {
    public static SelenideElement checkoutButton = $x("//*[@id=\"checkout\"]");
    public static SelenideElement checkoutPageTitle = $x("//span[@class='title'][contains(.,'Your Cart')]");
}
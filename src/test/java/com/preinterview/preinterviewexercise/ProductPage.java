package com.preinterview.preinterviewexercise;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * This is product page that contains all list of product Items
 */
public class ProductPage {
    public static SelenideElement pageTitle = $x("//span[@class='title']");
    public static SelenideElement shoppingCartButton = $x(" //a[@class='shopping_cart_link']");

}

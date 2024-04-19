package com.preinterview.preinterviewexercise;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Login page with 3 parameters for entering username, password and click the login button
 */
public class LoginPage {
    public static SelenideElement usernameInput = $x("//input[@id='user-name']");
    public static SelenideElement passwordInput = $x("//input[@id='password']");
    public static SelenideElement loginButton = $x("//input[@id='login-button']");
}

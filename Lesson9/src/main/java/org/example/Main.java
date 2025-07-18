package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Set the path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");




        // Initialize a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the MTS Belarus website
            driver.get("https://www.mts.by/");

            // Optional: Maximize the browser window
            driver.manage().window().maximize();

            // Optional: Print the page title
            System.out.println("Page title is: " + driver.getTitle());

            // Keep the browser open for a while (for demonstration)
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
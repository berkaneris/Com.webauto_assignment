package utils;

import org.openqa.selenium.JavascriptExecutor;

public class JSUtils {

    private static JavascriptExecutor js;

    public static void executeJavaScript(String script){
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript(script);
    }
}

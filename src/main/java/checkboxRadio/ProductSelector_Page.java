package checkboxRadio;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class ProductSelector_Page extends BasePage {

    @FindBy(css = ".brand-options label")
    private List<WebElement> brandList;

    @FindBy(css = ".shape-options label")
    private List<WebElement> shapeList;

    @FindBy(css = ".toggle-options label")
    private List<WebElement> styleList;

    @FindBy(css = ".shape")
    private WebElement shape;
    public void clickOnBrand(int index){
        brandList.get(index - 1).click();
    }
    public void clickOnShape(int index){
        shapeList.get(index - 1).click();
    }
    public void clickOnStyle(int index){
        styleList.get(index - 1).click();
    }

    public String getBrandName(){
        return shape.getText();
    }

    public String getShapeName(){
        return shape.getAttribute("class").split(" ")[1];
    }

    public String getBackgroundColor(){
       String color = shape.getAttribute("style");
       return color.substring(18 , color.length() - 1);
    }
    public boolean isContainsStyle(String styleName){
        return shape.getAttribute("class").contains(styleName);
    }
    public boolean isBrandSelected(int index){
        return brandList.get(index -1).isSelected();
    }
    public boolean isShapeSelected(int index){
        return shapeList.get(index -1).isSelected();
    }
    public boolean isStyleSelected(int index){
        return styleList.get(index -1).isSelected();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.Browser.getDriver;

public class TablePage extends MainPage {

    //получаем ячейку таблицы
    public WebElement getCell(int col, int row, String table) {
        String xpath = String.format(table, row, col);
        return getDriver().findElement(By.xpath(xpath));
    }

       //получаем заголовки таблицы
    public static List<WebElement> getTableHeaders() {
        return getDriver().findElements(By.xpath("//th"));
    }
}

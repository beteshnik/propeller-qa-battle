package service;

import common.Application;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static common.Browser.getDriver;


public class ServicePage {


    //получаем абсолютный путь к файлу
    public static String getAbsolutePath(String path) throws IOException {
        System.out.println(new File("src/test/resources/data/" + path).getCanonicalPath());
        return new File("src/test/resources/data/" + path).getCanonicalPath();
    }

    public static void clickAndMakeScreenshot(WebElement element, String message) throws IOException {
        makeScreenShot("Before click by: " + message);
        Application.log(String.format("Click by '%s'", message));
        element.click();
    }

    public static void makeScreenShot(String message) throws IOException {
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(getAbsolutePath("/screenshots/"+currentDate()+".png")));
    }

        public static void waitSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //определяем текущую дату
    public static String currentDate() {
        DateTimeFormatter date = (DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss"));
        LocalDateTime now = LocalDateTime.now();
        return date.format(now);
    }

    //определяем текущую дату в Unix формате
    public static long currentUnixTime() {
        return System.currentTimeMillis() / 1000L;
    }

    // читаем файл в строку
    public static String readFile(String path)  throws  IOException {
        String contents = new String(Files.readAllBytes(Paths.get(path)));
        return contents;
    }

    //удаляем файл
    public static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

}




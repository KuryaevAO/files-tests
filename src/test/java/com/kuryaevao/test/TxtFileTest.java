package com.kuryaevao.test;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TxtFileTest {

    @Test
    void txtTest() throws IOException {

        //Объявляем все переменные
        String txtFilePath = "./src/test/resources/Шпаргалка по Allure.txt";
        String expectedData = "Пример кода Lambda Steps";
        String actualData;
        File txtFile = new File(txtFilePath);

        //Приводим файл в форму String и сравниваем содержимое
        actualData = FileUtils.readFileToString(txtFile, StandardCharsets.UTF_8);
        Assertions.assertTrue(actualData.contains(expectedData));
    }
}

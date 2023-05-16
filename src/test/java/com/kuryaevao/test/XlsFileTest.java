package com.kuryaevao.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class XlsFileTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        Configuration.browserSize = "3840×2160";
        Configuration.pageLoadTimeout = 600000;
    }

    @Test
    void downloadXlsTest() throws Exception {

        String expectedData = "January";

        //Качаем PDF c сайта
        open("https://filesamples.com/formats/xls");
        File download = $("#output").$("a").download();

        ////Сравниваем конкретную ячейку с ожидаемым результатом
        XLS xls = new XLS(download);
        assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(1).toString()).isEqualTo(expectedData);
    }
}

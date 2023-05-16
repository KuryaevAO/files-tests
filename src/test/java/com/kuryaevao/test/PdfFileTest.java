package com.kuryaevao.test;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PdfFileTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        Configuration.browserSize = "3840×2160";
        Configuration.pageLoadTimeout = 600000;
    }

    @Test
    void downloadPdfTest() throws Exception {

        String expectedData = "Sample #1";

        //Качаем PDF c сайта
        open("https://filesamples.com/formats/pdf");
        File download = $("#output").$("a").download();

        //Сравниваем заголовок с ожидаемым результатом
        PDF parsed = new PDF(download);
        assertThat(parsed.title).isEqualTo(expectedData);
    }
}

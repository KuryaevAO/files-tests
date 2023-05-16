package com.kuryaevao.test;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocFileTest {

    @Test
    void docTest() throws IOException {

        //Объявляем все переменные
        String docFilePath = "./src/test/resources/hi.docx";
        String expectedData = "Привет, мир, получается!";
        String actualData;
        File docFile = new File(docFilePath);

        //Парсим docx
        FileInputStream fis = new FileInputStream(docFile);
        XWPFDocument document = new XWPFDocument(fis);
        XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        actualData = extractor.getText();
        Assertions.assertTrue(actualData.contains(expectedData));

        /*P.S. - данный тест у меня не заработал из-за постоянно возникающей ошибки
                 java.lang.NoClassDefFoundError: org/apache/poi/util/POILogFactory
                 Погуглив, я понял, что нужна библиотека apache.poi, я пытался ее
                 запихнуть во все возможные места, в build.gradle даже в нескольких вариантах,
                 но у меня так и не вышло прогнать тест.
                 По идее код должен быть верный */
    }
}

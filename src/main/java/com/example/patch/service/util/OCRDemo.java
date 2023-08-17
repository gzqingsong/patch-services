package com.example.patch.service.util;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.Word;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.util.List;
import java.awt.image.BufferedImage;
import java.nio.file.Files;

public class OCRDemo {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("tessdata");
            tesseract.setLanguage("eng");
            String result = tesseract.doOCR(new File("F:\\GZOU\\考务\\test\\test\\2144101413850.png"));
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
//public static void main(String[] args) throws Exception{
//    File imageFile = new File("F:\\\\GZOU\\\\考务\\\\test\\\\test\\\\2144101413850.png");
//    //ITesseract instance = new Tesseract();  // JNA Interface Mapping
//    // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
//    //instance.setDatapath("F:\GZOU\code\Tess4J\tessdata"); // path to tessdata directory
//    BufferedImage bi = ImageIO.read(Files.newInputStream(imageFile.toPath()));
//    ITesseract instance = getInstance();
//
//    // 获取识别的词汇列表
//    List<Word> wordList = instance.getWords(bi, ITessAPI.TessPageIteratorLevel.RIL_WORD);
//
////    try {
////        String result = instance.doOCR(imageFile);
////        System.out.println(result);
////    } catch (TesseractException e) {
////        System.err.println(e.getMessage());
////    }
//    }

    private static ITesseract getInstance() {
        ITesseract instance = new Tesseract();

        // 设置tessdata目录, 下载地址： https://github.com/tesseract-ocr/tessdata_best
        instance.setDatapath("tessdata");

        /**
         * 设置需要识别的语种,
         *   chi_sim+eng： 表示识别简体中文和英文;
         *   eng: 仅识别英文
         */
        instance.setLanguage("eng");

        instance.setOcrEngineMode(1); // 设置OCR引擎模式（OEM）
        instance.setPageSegMode(6);   // 设置图片分割模式（PSM）

        return instance;
    }

}

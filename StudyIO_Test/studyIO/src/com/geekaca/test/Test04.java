package com.geekaca.test;

import org.apache.commons.io.FileUtils;
import java.io.*;

public class Test04 {
    public static void main(String[] args) {
        try {
            FileUtils.copyDirectoryToDirectory(new File("D:\\study\\lesson\\JAVA_stage2\\d032\\StudyIO_Test\\studyIO\\"),
                    new File("D:\\study\\test"));
            FileUtils.copyFile(new File("D:\\study\\lesson\\JAVA_stage2\\d032\\StudyIO_Test\\studyIO\\JavaWordList.txt"),
                    new File("D:\\study\\test\\list.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

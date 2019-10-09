package main;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;

public class ImportData {
    public static void main(String[] args) throws DocumentException {
        SAXReader sax = new SAXReader();
        ArrayList<String> files = getFiles("/Users/lirance/Documents/AllPublicXML");

        int i = 0;
        for (String path : files) {
            i++;
            if (i < 99000) {
                continue;
            }
            if (i % 1000 == 0) {
                System.out.println("already" + i);
            }

            if (!path.endsWith(".xml")) {
                continue;
            }
            File xmlFile = new File(path);
            Document document = sax.read(xmlFile);
            Element root = document.getRootElement();
            new ReadXml().getNodes(root);
        }


        System.out.println("Done");


    }

    private static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (File file1 : tempList) {
            if (file1.isDirectory()) {
                File[] files1 = file1.listFiles();
                for (File file2 : files1) {
                    files.add(file2.toString());
                }
            }
        }
        return files;
    }

}
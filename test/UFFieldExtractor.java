package org.example.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class UFFieldExtractor {
    public static void main(String[] args) throws Exception {
        File input = new File("fields.txt");
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements rows = doc.select("a");
        Map<String, String> fieldsMap = new LinkedHashMap<>();
        for (Element link : rows) {
            String href = link.attr("href");
            String text = link.text();
            if (href.contains("UF_CRM_")) {
                String id = href.substring(href.lastIndexOf("UF_CRM_")).replace("/", "");
                fieldsMap.put(text, id);
                System.out.println(text + " : " + id);
            }
        }

        System.out.println(fieldsMap.size());
    }
}

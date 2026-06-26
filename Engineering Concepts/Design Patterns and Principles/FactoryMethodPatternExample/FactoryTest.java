package FactoryMethodPatternExample;
public class FactoryTest {

    public static void main(String[] args) {

        DocumentFactory factory;

        // Create Word Document
        factory = new WordFactory();
        factory.openDocument();

        // Create PDF Document
        factory = new PdfFactory();
        factory.openDocument();

        // Create Excel Document
        factory = new ExcelFactory();
        factory.openDocument();
    }
}
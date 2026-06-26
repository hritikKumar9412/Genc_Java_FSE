package FactoryMethodPatternExample;

public abstract class DocumentFactory {

    // Factory Method
    public abstract Document createDocument();

    // Common operation
    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}
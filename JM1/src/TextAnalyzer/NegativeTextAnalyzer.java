package TextAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

    @Override
    public String[] getKeywords() {
        return new String[] {":(", "=(", ":|"};
    }

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

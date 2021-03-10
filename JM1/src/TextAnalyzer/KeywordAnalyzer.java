package TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer{
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String key : getKeywords()) {
            if (text.contains(key)) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

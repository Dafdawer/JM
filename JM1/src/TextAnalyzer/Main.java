package TextAnalyzer;

public class Main {
    public static void main(String[] args) {
        String[] spam = {"fuck", "shit", "gavno"};
        String[] tests = {
                "Reel good string, yea",
                "fuck THIS FUCKING SHIT GAVNO",
                "I'm so sad :(",
                "Sooooooooooooooo blooooody looooooooooooooooooooong!!!!!!!"
        };

        TextAnalyzer[] one = { new SpamAnalyzer(spam), new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(30)};

        for (int i = 0; i < 3; i++) {
            System.out.printf("Test%d:\n", i + 1);
            for (String test : tests) {
                TextAnalyzer[] ta = {one[i]};
                System.out.println(checkLabels(ta, test));
            }
        }
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {    // remove static!
        for (TextAnalyzer test : analyzers) {
            if (!test.processText(text).equals(Label.OK)) {
                return test.processText(text);
            }
        }
        return Label.OK;
    }
}

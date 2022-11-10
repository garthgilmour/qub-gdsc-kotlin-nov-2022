package interop.tokotlin;

public class Program {
    public static void main(String[] args) {
        MyStuff.awkward();

        AwkwardKotlin ak1 = new AwkwardKotlin();
        AwkwardKotlin ak2 = new AwkwardKotlin();
        ak2.setSuggestion("drink milk");

        AwkwardKotlin.Extras.makeSuggestion(ak1);
        AwkwardKotlin.Extras.makeSuggestion(ak2);

        ak1.foo("Peter", "Lois");
        ak1.bar();
        ak1.bar("Bart");
        ak1.bar("Bart", "Liza");
    }
}

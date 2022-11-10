package interop.tojava;

public class AwkwardJava {
    private String suggestion;
    private boolean awkward;

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public boolean isAwkward() {
        return awkward;
    }

    public void setAwkward(boolean awkward) {
        this.awkward = awkward;
    }

    public void object() {
        if(awkward) {
            System.out.printf("Your idea to '%s' is refused!\n", suggestion);
        } else {
            System.out.printf("Sure, you can '%s' if you like\n", suggestion);
        }
    }
}

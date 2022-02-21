package model.type;

public enum Feeling {
    AWKWARDNESS("неловкость"),
    SAD("грусть"),
    CRINGE("кринж");

    private String title;

    Feeling(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

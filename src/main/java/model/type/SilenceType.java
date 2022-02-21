package model.type;

public enum SilenceType {
    AWKWARD("неловкое"),
    SUITABLE("уместное"),
    CRINGE("кринжовое");

    private String title;

    SilenceType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

package model.type;

public enum Color {
    WHITE("белый"),
    BLACK("черный"),
    GRAY("серый");

    private String title;

    Color(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

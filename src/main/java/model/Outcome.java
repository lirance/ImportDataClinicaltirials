package model;

public class Outcome extends OutcomeKey {
    private String outcomeTitle;

    private String outcomeDescripition;

    public String getOutcomeTitle() {
        return outcomeTitle;
    }

    public void setOutcomeTitle(String outcomeTitle) {
        this.outcomeTitle = outcomeTitle == null ? null : outcomeTitle.trim();
    }

    public String getOutcomeDescripition() {
        return outcomeDescripition;
    }

    public void setOutcomeDescripition(String outcomeDescripition) {
        this.outcomeDescripition = outcomeDescripition == null ? null : outcomeDescripition.trim();
    }
}
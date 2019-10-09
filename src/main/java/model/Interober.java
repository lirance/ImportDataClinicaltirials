package model;

public class Interober {
    private Integer interoberId;

    private String interoberName;

    private String interoberType;

    private String interoberDescription;

    public Integer getInteroberId() {
        return interoberId;
    }

    public void setInteroberId(Integer interoberId) {
        this.interoberId = interoberId;
    }

    public String getInteroberName() {
        return interoberName;
    }

    public void setInteroberName(String interoberName) {
        this.interoberName = interoberName == null ? null : interoberName.trim();
    }

    public String getInteroberType() {
        return interoberType;
    }

    public void setInteroberType(String interoberType) {
        this.interoberType = interoberType == null ? null : interoberType.trim();
    }

    public String getInteroberDescription() {
        return interoberDescription;
    }

    public void setInteroberDescription(String interoberDescription) {
        this.interoberDescription = interoberDescription == null ? null : interoberDescription.trim();
    }
}
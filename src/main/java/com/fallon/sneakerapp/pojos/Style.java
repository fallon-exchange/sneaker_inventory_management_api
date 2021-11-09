package com.fallon.sneakerapp.pojos;

public class Style {
    String styleId;
    String styleName;
    String type;
    String subType;

    public Style(String styleId, String styleName, String type, String subType) {
        this.styleId = styleId;
        this.styleName = styleName;
        this.type = type;
        this.subType = subType;
    }

    public Style() {
    }



    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}

package com.example.cs4550f20serverjavamichellekang.models;

public class Widget {
    private String name; // Optional name of the widget
    private String id; // Widget's unique identifier
    private String type; // Type of the widget, e.g., Heading, List, Paragraph, Image, YouTube, HTML, Link
    private Integer widgetOrder; // Order with respect to widgets in the same list
    private String text; // Plain text useful for heading text, paragraph text, link text, etc
    private String src; // Absolute or relative URL referring to online resource
    private Integer size; // Useful to represent size of widget, e.g., heading size
    private Integer height; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
    private Integer width; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
    private String cssClass; // CSS class implementing some CSS rule and transformations configured in some CSS rule
    private String value; // Some arbitrary initial value interpreted by the widget

    private String topicId;
    private String movement; // value when up or down is clicked for that widget

    public Widget(String id, String type, String name) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public Widget(String id, String type, String name, String topicId) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.topicId = topicId;
    }

    public Widget() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }


}
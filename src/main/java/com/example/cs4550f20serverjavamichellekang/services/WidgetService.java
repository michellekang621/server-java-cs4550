// NOT CONCERNED WITH HTP. THAT'S WIDGETCONTROLLER'S JOB
package com.example.cs4550f20serverjavamichellekang.services;

import com.example.cs4550f20serverjavamichellekang.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();

    {
//        widgets.add(new Widget("123", "HTML", "Widget 1", "topic123"));
//        widgets.add(new Widget("234", "YOU_TUBE", "Widget 2", "topic123"));
//        widgets.add(new Widget("345", "SLIDE", "Widget 3", "topic123"));
//        widgets.add(new Widget("456", "HEADER", "Widget 4", "topic123"));
        widgets.add(new Widget("123", "PARAGRAPH", "Widget 1", "topic123"));
        widgets.add(new Widget("234", "HEADING", "Widget 2", "topic123"));
        widgets.add(new Widget("345", "PARAGRAPH", "Widget 3", "topic123"));
        widgets.add(new Widget("456", "HEADING", "Widget 4", "topic123"));

        widgets.add(new Widget("567", "HEADING", "Widget A", "topic234"));
        widgets.add(new Widget("678", "PARAGRAPH", "Widget B", "topic234"));

    }

    // url must end in a plural noun
    // use the path to establish the hierarchy
    // if you want specific "widget" (in this case) then encode the keyID into the url

    // Get = FindAll
    // Get = Find
    // Post = Create
    // Delete = Delete
    // Put = Update

    public Widget createWidget(String topicId, Widget widget) {
        System.out.println("WIDGET CREATING IN JAVA");
        String newId = (new Date().toString());
        widget.setId(newId);
        widget.setTopicId(topicId);
        widget.setName("NEW WIDGET");
        widget.setWidgetOrder(widgets.size());
        widget.setSize(3);
        widgets.add(widget);
        return widget;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> widgetsForTopic = new ArrayList<>();
        for(Widget w: widgets) {
            if (w.getTopicId().equals(topicId)) {
                widgetsForTopic.add(w);
            }
        }
        return widgetsForTopic;
    }

    public Widget updateWidget(String widgetId, Widget widget) {
        for (Widget w: widgets) {
            if (w.getId().equals(widgetId)) {
                w = widget;
                return w;
            }
        }
        return null;
    }

    public Widget deleteWidget(String widgetId) {
        Widget deleted = null;
        System.out.println("GIVEN ID: " + widgetId);
        for (Widget w : widgets) {
            System.out.println("CURR ID: " + w.getId());
            if (w.getId().equals(widgetId)) {
                System.out.println("WIDGET DELETED IN SERVICE");
                deleted = w;
                System.out.println(deleted);
                widgets.remove(w);
            }
        }
        return deleted;
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public Widget findWidgetById(String widgetId) {
        for(Widget w:widgets) {
            if (w.getId().equals(widgetId)) {
                return w;
            }
        }
        return null;
    }

    public List<Widget> moveWidgetUp(Widget widget, String topicId) {
        List<Widget> widgetsForTopic = new ArrayList<>();
        Integer originalOrder = widget.getWidgetOrder();
        Integer newOrder = originalOrder - 1;


        for(Widget w: widgets) {
            if (w.getTopicId().equals(topicId)) {
                widgetsForTopic.add(w);
            }
        }

        for(Widget w: widgetsForTopic) {
            if (w.getWidgetOrder().equals(originalOrder)) {
                w.setWidgetOrder(newOrder);
            } else if  (w.getWidgetOrder().equals(newOrder) && !w.getId().equals(widget.getId())) {
                w.setWidgetOrder(originalOrder);
            }
        }
        return widgetsForTopic;
    }

    public List<Widget> moveWidgetDown(Widget widget, String topicId) {
        List<Widget> widgetsForTopic = new ArrayList<>();
        Integer originalOrder = widget.getWidgetOrder();
        Integer newOrder = originalOrder + 1;


        for(Widget w: widgets) {
            if (w.getTopicId().equals(topicId)) {
                widgetsForTopic.add(w);
            }
        }

        for(Widget w: widgetsForTopic) {
            if (w.getWidgetOrder().equals(originalOrder)) {
                w.setWidgetOrder(newOrder);
            } else if  (w.getWidgetOrder().equals(newOrder) && !w.getId().equals(widget.getId())) {
                w.setWidgetOrder(originalOrder);
            }
        }
        return widgetsForTopic;
    }
}

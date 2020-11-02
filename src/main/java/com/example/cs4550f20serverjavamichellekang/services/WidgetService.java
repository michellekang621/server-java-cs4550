// NOT CONCERNED WITH HTP. THAT'S WIDGETCONTROLLER'S JOB
package com.example.cs4550f20serverjavamichellekang.services;

import com.example.cs4550f20serverjavamichellekang.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();

    {
        widgets.add(new Widget("123", "HTML", "Widget 1", "topic123"));
        widgets.add(new Widget("234", "YOU_TUBE", "Widget 2", "topic123"));
        widgets.add(new Widget("345", "SLIDE", "Widget 3", "topic123"));
        widgets.add(new Widget("456", "HEADER", "Widget 4", "topic123"));
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

    public Integer updateWidget(String widgetId, Widget widget) {
        for (Widget w: widgets) {
            if (w.getId().equals(widgetId)) {
                w = widget;
                return 1;
            }
        }
        return 0;
    }

    public Widget deleteWidget(String widgetId) {
        for (Widget w : widgets) {
            if (w.getId().equals(widgetId)) {
                widgets.remove(w);
                return w;
            }
        }
        return null;
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
}

// NOT CONCERNED WITH HTP. THAT'S WIDGETCONTROLLER'S JOB
package com.example.cs4550f20serverjavamichellekang.services;

import com.example.cs4550f20serverjavamichellekang.models.Widget;
import com.example.cs4550f20serverjavamichellekang.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    @Autowired
    WidgetRepository widgetRepository;

    List<Widget> widgets = new ArrayList<Widget>();

    {
//        widgets.add(new Widget("123", "HTML", "Widget 1", "topic123"));
//        widgets.add(new Widget("234", "YOU_TUBE", "Widget 2", "topic123"));
//        widgets.add(new Widget("345", "SLIDE", "Widget 3", "topic123"));
//        widgets.add(new Widget("456", "HEADER", "Widget 4", "topic123"));
        widgets.add(new Widget(123, "PARAGRAPH", "Widget 1", "topic123"));
        widgets.add(new Widget(234, "HEADING", "Widget 2", "topic123"));
        widgets.add(new Widget(345, "PARAGRAPH", "Widget 3", "topic123"));
        widgets.add(new Widget(456, "HEADING", "Widget 4", "topic123"));

        widgets.add(new Widget(567, "HEADING", "Widget A", "topic234"));
        widgets.add(new Widget(678, "PARAGRAPH", "Widget B", "topic234"));

    }

    // url must end in a plural noun
    // use the path to establish the hierarchy
    // if you want specific "widget" (in this case) then encode the keyID into the url

    // Get = FindAll
    // Get = Find
    // Post = Create
    // Delete = Delete
    // Put = Update

    public List<Widget> helper(String topicId) {
        List<Widget> widgetsForTopic = new ArrayList<>();
        for(Widget w: widgets) {
            if (w.getTopicId().equals(topicId)) {
                widgetsForTopic.add(w);
            }
        }
        return widgetsForTopic;
    }

    public Widget createWidget(Widget widget) {
        return widgetRepository.save(widget);
//        System.out.println("WIDGET CREATING IN JAVA");
//        Integer newId = 321;
//        widget.setId(newId);
//        widget.setTopicId(topicId);
//        widget.setName("NEW WIDGET");
//        widget.setWidgetOrder(helper(topicId).size());
//        widget.setSize(3);
//        widgets.add(widget);
//        return widget;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        return widgetRepository.findWidgetsByTopicId(topicId);
//        List<Widget> widgetsForTopic = new ArrayList<>();
//        for(Widget w: widgets) {
//            if (w.getTopicId().equals(topicId)) {
//                widgetsForTopic.add(w);
//            }
//        }
//        return widgetsForTopic;
    }

    public Widget updateWidget(Integer widgetId, Widget widget) {
        Widget w = widgetRepository.findById(widgetId).get();
        w.setName(widget.getName());
        return widgetRepository.save(w);
//        for (Widget w: widgets) {
//            if (w.getId().equals(widgetId)) {
//                w = widget;
//                return w;
//            }
//        }
//        return null;
    }

    public void deleteWidget(Integer widgetId) {
        widgetRepository.deleteById(widgetId);
//        Widget deleted = null;
//        System.out.println("GIVEN ID: " + widgetId);
//        for (Widget w : widgets) {
//            System.out.println("CURR ID: " + w.getId());
//            if (w.getId().equals(widgetId)) {
//                System.out.println("WIDGET DELETED IN SERVICE");
//                deleted = w;
//                System.out.println(deleted);
//                widgets.remove(w);
//            }
//        }
//        return deleted;
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
//        return widgets;
    }

    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).get();
//        for(Widget w:widgets) {
//            if (w.getId().equals(widgetId)) {
//                return w;
//            }
//        }
//        return null;
    }

    public List<Widget> moveWidgetUp(Widget widget, String topicId) {
        List<Widget> widgetsForTopic = new ArrayList<>();
        Integer originalOrder = widget.getWidgetOrder();
        Integer newOrder = originalOrder - 1;

        widgetsForTopic = helper(topicId);

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


        widgetsForTopic = helper(topicId);

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

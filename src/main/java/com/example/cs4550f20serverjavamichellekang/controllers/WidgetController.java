// ONLY CONCERNED WITH IMPLEMENTING HTP TO THE JAVA WORLD
package com.example.cs4550f20serverjavamichellekang.controllers;

import com.example.cs4550f20serverjavamichellekang.models.Widget;
import com.example.cs4550f20serverjavamichellekang.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService service;

    // url must end in a plural noun
    // use the path to establish the hierarchy
    // if you want specific "widget" (in this case) then encode the keyID into the url

    // Get = FindAll
    // Get = Find
    // Post = Create
    // Delete = Delete
    // Put = Update

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidgetForTopic(
            @PathVariable("topicId") String topicId,
            @RequestBody Widget widget) {
        widget.setTopicId(topicId);
        return service.createWidget(widget);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }

    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(
            @PathVariable("wid") Integer widgetId,
            @RequestBody Widget widget) {
//        return service.updateWidget(widgetId, widget);
        return service.updateWidget(widgetId, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public void deleteWidget(
            @PathVariable("wid") Integer widgetId) {
        service.deleteWidget(widgetId);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") Integer widgetId) {
        return service.findWidgetById(widgetId);
    }

    @PutMapping("/api/topics/{tid}/widgets")
    public List<Widget> moveWidget(
            @RequestBody Widget widget,
            @PathVariable("tid") String topicId) {
        if (widget.getMovement().equals("up")) {
            return service.moveWidgetUp(widget, topicId);
        } else if (widget.getMovement().equals("down")) {
            return service.moveWidgetDown(widget, topicId);
        } else {
            return null;
        }
    }

}

package com.rungroup.web.models;

import java.util.HashMap;
import java.util.Map;

public class EventAdapter implements TargetAdapter {
    private Event adaptee;

    public EventAdapter(Event adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public Long gettarget_id() {
        return adaptee.getId();
    }

    @Override
    public String getTargetName() {
        return adaptee.getName();
    }

    @Override
    public Map<String, Object> getTargetData() {
        Map<String, Object> targetData = new HashMap<>();
        targetData.put("id", adaptee.getId());
        targetData.put("name", adaptee.getName());
        targetData.put("description", adaptee.getDescription());
        targetData.put("image_url", adaptee.getImage_url());
        targetData.put("date", adaptee.getDate());
        targetData.put("location", adaptee.getLocation());
        targetData.put("created_at", adaptee.getCreated_at());
        targetData.put("updated_at", adaptee.getUpdated_at());
        return targetData;
    }

}

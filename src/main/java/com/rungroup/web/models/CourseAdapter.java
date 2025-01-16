package com.rungroup.web.models;

import java.util.HashMap;
import java.util.Map;

public class CourseAdapter implements TargetAdapter {
    private Course adaptee;

    public CourseAdapter(Course adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public Long getTargetId() {
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
        targetData.put("credits", adaptee.getCredits());
        targetData.put("time_slot", adaptee.getTime_slot());
        targetData.put("progress", adaptee.getProgress());
        targetData.put("created_at", adaptee.getCreated_at());
        targetData.put("updated_at", adaptee.getUpdated_at());
        return targetData;
    }

}

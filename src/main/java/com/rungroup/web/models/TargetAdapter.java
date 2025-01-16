package com.rungroup.web.models;

import java.util.Map;

public interface TargetAdapter {
    public Long getTargetId();

    public String getTargetName();

    public Map<String, Object> getTargetData();

}

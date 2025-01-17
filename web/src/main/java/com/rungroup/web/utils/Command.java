package com.rungroup.web.utils;

public interface Command {
    void execute();
    void undo();
}
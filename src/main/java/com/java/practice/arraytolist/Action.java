package com.java.practice.arraytolist;

public enum Action {
    DEPLOY("DEPLOY"),
    MAP("MAP"),
    ENABLE("ENABLE"),
    DISABLE("DISABLE"),
    ALL("ALL");

    private String action;

    Action(String key) {
        this.action = key;
    }

    public static Action fromString(String action) {
        return action == null
            ? null
            : Action.valueOf(action.toUpperCase());
    }

    public String getAction() {
        return action;
    }
}


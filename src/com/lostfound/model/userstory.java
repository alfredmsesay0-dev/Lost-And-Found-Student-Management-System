package com.lostfound.model;

public class userstory {

    private String id;
    private String title;
    private String useCase;
    private moscowpriority priority;


    public userstory(String id, String title, String useCase, moscowpriority priority) {

        this.id = id;
        this.title = title;
        this.useCase = useCase;
        this.priority = priority;

    }


    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getUseCase() {
        return useCase;
    }


    public moscowpriority getPriority() {
        return priority;
    }


    @Override
    public String toString() {

        return id + " | "
                + title + " | "
                + useCase + " | "
                + priority;

    }


}

package com.qacart.todo.objects;

public class Task {
    private boolean isCompleted;
    private String item;

    public Task(String item , boolean isCompleted){
        this.item = item;
        this.isCompleted = isCompleted;
    }
    public boolean getisCompleted() {
        return isCompleted;
    }

    public void setisCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }



}

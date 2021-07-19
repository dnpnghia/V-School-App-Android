package com.example.v_school;

public class Student {
    private String id;
    private String name;
    private String classes;
    private String idSchool;
    private String idParent;

    public Student() {
    }

    public Student(String id, String name, String classes, String idSchool, String idParent) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.idSchool = idSchool;
        this.idParent = idParent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(String idSchool) {
        this.idSchool = idSchool;
    }

    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }
}

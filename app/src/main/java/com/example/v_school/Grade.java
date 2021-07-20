package com.example.v_school;

public class Grade {
    private int id;
    private String semeter;
    private String year;
    private String idStudent;
    private float toan;
    private float van;
    private float anh;
    private float tb = (toan+van+anh)/3;

    public Grade(int id, String semeter, String year, String idStudent, float toan, float van, float anh ){
        this.id = id;
        this.semeter = semeter;
        this.year = year;
        this.idStudent = idStudent;
        this.toan = toan;
        this.van = van;
        this.anh = anh;

    }

    public Grade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemeter() {
        return semeter;
    }

    public void setSemeter(String semeter) {
        this.semeter = semeter;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getVan() {
        return van;
    }

    public void setVan(float van) {
        this.van = van;
    }

    public float getAnh() {
        return anh;
    }

    public void setAnh(float anh) {
        this.anh = anh;
    }

    public float getTb() {
        return (toan+van+anh)/3;
    }

    public void setTb(float tb) {
        this.tb = tb;
    }
}

package com.geekaca.survey.pojo;

import java.time.LocalDate;

public class MainInfo {
    //id, title_main, date_main
    private Integer id;
    private String titleMain;
    private LocalDate dateMain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleMain() {
        return titleMain;
    }

    public void setTitleMain(String titleMain) {
        this.titleMain = titleMain;
    }

    public LocalDate getDateMain() {
        return dateMain;
    }

    public void setDateMain(LocalDate dateMain) {
        this.dateMain = dateMain;
    }

    @Override
    public String toString() {
        return "MainInfo{" +
                "id=" + id +
                ", titleMain='" + titleMain + '\'' +
                ", dateMain=" + dateMain +
                '}';
    }
}

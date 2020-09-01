package com.example.filmrate_v1.pojo;

import java.util.List;

public class YTSModel {
    private String status;
    private String status_message;
    private Data data;

    public YTSModel(String status, String status_message, Data data) {
        this.status = status;
        this.status_message = status_message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

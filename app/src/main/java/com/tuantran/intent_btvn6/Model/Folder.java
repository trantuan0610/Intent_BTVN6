package com.tuantran.intent_btvn6.Model;

import java.io.Serializable;

public class Folder implements Serializable {
    private String title;
    private String mota;

    public Folder(String title, String mota) {
        this.title = title;
        this.mota = mota;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

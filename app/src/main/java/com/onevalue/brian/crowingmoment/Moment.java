package com.onevalue.brian.crowingmoment;

import java.util.UUID;

/**
 * Created by brian on 15. 7. 23..
 * model class
 */
public class Moment {

    private UUID mId; //for identify moment item
    private String mTitle; //the title of moment item

    public Moment() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}

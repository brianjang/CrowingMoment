package com.onevalue.brian.crowingmoment;

//import java.sql.Date;

import java.util.Date;
import java.util.UUID;


/**
 * Created by brian on 15. 7. 23..
 * model class
 */
public class Moment {

  private UUID mId; //for identify moment item
  private String mTitle; //the title of moment item
  private Date mDate;
  private boolean mSave;

  public Moment() {

    mId = UUID.randomUUID();
    mDate = new Date();
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

  public Date getDate() {
    return mDate;
  }

  public void setDate(Date date) {
    mDate = date;
  }

  public boolean isSave() {
    return mSave;
  }

  public void setSave(boolean save) {
    mSave = save;
  }

  @Override
  public String toString() {
    return mTitle;
  }
}

package org.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class Lend {
    private String bookId;
    private String readerId;
    private String bookName;
    private String publisher;
    private float price;
    private String ISBN;
    private String lendTime;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lTime) {
        this.lendTime = lTime;
    }
}

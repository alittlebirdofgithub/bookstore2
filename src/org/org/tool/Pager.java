package org.org.tool;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class Pager {
    private int pageNow;
    private int pageSize;
    private int totalPage;
    private int totalSize;
    private boolean hasFirst;
    private boolean hasPre;
    private boolean hasNext;
    private boolean hasLast;

    public boolean getHasFirst() {
        if(pageNow == 1) return false;
        return true;
    }

    public boolean getHasNext() {
        if(isHasLast()) return true;
        return false;
    }

    public  boolean getHasPre() {
        if(this.isHasFirst()) return true;
        return false;
    }

    public boolean getHasLast() {
        if(pageNow == this.getTotalPage()) return false;
        return true;
    }

    public Pager(int pageNow, int totalSize) {
        this.pageNow = pageNow;
        this.totalSize = totalSize;
        this.pageSize = 4;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        totalPage = getTotalSize() / getPageSize();
        if(totalSize % pageSize != 0) {
            totalPage ++;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public boolean isHasFirst() {
        if(pageNow == 1) return false;
        return true;
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    public boolean isHasPre() {
        if(this.isHasFirst()) return true;
        return false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {
        if(isHasLast()) return true;
        return false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasLast() {
        if(pageNow == this.getTotalPage()) return false;
        return true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }
}

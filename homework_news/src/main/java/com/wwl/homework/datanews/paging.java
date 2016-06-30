package com.wwl.homework.datanews;

/**
 * Created by Administrator on 2016/6/24.
 */
public class paging {
private String totalrow;
    private String totalpage;
    private int page;

    public paging(String totalrow, String totalpage, int page) {
        this.totalrow = totalrow;
        this.totalpage = totalpage;
        this.page = page;
    }

    public String getTotalrow() {
        return totalrow;
    }

    public void setTotalrow(String totalrow) {
        this.totalrow = totalrow;
    }

    public String getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(String totalpage) {
        this.totalpage = totalpage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

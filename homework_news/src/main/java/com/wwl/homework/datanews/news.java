package com.wwl.homework.datanews;

/**
 * Created by Administrator on 2016/6/24.
 */
public class news {
    private data data;
    private com.wwl.homework.datanews.paging paging;

    public news(com.wwl.homework.datanews.data data, com.wwl.homework.datanews.paging paging) {
        this.data = data;
        this.paging = paging;
    }

    public com.wwl.homework.datanews.data getData() {
        return data;
    }

    public void setData(com.wwl.homework.datanews.data data) {
        this.data = data;
    }

    public com.wwl.homework.datanews.paging getPaging() {
        return paging;
    }

    public void setPaging(com.wwl.homework.datanews.paging paging) {
        this.paging = paging;
    }
}

package platform.framework.core.pager;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/8
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class Pager<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private long iTotalRecords;
    private long iTotalDisplayRecords;
    private int sEcho;
    private List<T> aaData = Collections.emptyList();

    public Pager(List<T> list) {
        this.aaData = list;
    }

    public Pager(List<T> list, PagerQuery pagerQuery) {
        this.aaData = list;
        this.sEcho = pagerQuery.getsEcho();
    }

    public Pager(Pager<?> pager, PagerQuery pagerQuery, List<T> list) {
        this.aaData = list;
        this.sEcho = pagerQuery.getsEcho();
        this.iTotalDisplayRecords = pager.getiTotalDisplayRecords();
        this.iTotalRecords = pager.getiTotalRecords();
    }

    public Pager(Pager<?> pager, List<T> list) {
        this.aaData = list;
        this.sEcho = pager.getsEcho();
        this.iTotalDisplayRecords = pager.getiTotalDisplayRecords();
        this.iTotalRecords = pager.getiTotalRecords();
    }

    public Pager() {
    }

    public Pager(PagerQuery pagerQuery) {
        this.sEcho = pagerQuery.getsEcho();
    }

    public Pager(PagerQuery pagerQuery, long iTotalRecords) {
        this.sEcho = pagerQuery.getsEcho();
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalRecords;
    }

    public Pager(PagerQuery pagerQuery, long iTotalRecords, List<T> aaData) {
        this.sEcho = pagerQuery.getsEcho();
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalRecords;
        if(aaData != null) {
            this.aaData = aaData;
        }

    }

    public void setupResult(long iTotalRecords, List<T> aaData) {
        this.iTotalRecords = iTotalRecords;
        this.iTotalDisplayRecords = iTotalRecords;
        if(aaData != null) {
            this.aaData = aaData;
        }

    }

    public long getiTotalRecords() {
        return this.iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public long getiTotalDisplayRecords() {
        return this.iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public int getsEcho() {
        return this.sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    public List<T> getAaData() {
        return this.aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }

    public boolean isEmpty() {
        return this.aaData == null || this.aaData.isEmpty();
    }
}

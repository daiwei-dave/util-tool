package platform.framework.core.pager;

import java.io.Serializable;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/8
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class PagerQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    private int iDisplayStart = 0;
    private int iDisplayLength = 10;
    private int sEcho;
    private int iColumns;
    private String sColumns;
    private int iSortingCols;
    private Integer iSortCol_0;
    private String sSortDir_0;
    private Class domainClass;

    public PagerQuery() {
    }

    public PagerQuery(int iDisplayStart, int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
        this.iDisplayStart = iDisplayStart;
    }

    public int getiDisplayStart() {
        return this.iDisplayStart;
    }

    public void setiDisplayStart(int iDisplayStart) {
        this.iDisplayStart = iDisplayStart;
    }

    public int getiDisplayLength() {
        return this.iDisplayLength;
    }

    public void setiDisplayLength(int iDisplayLength) {
        this.iDisplayLength = iDisplayLength;
    }

    public int getsEcho() {
        return this.sEcho;
    }

    public void setsEcho(int sEcho) {
        this.sEcho = sEcho;
    }

    public int getiColumns() {
        return this.iColumns;
    }

    public void setiColumns(int iColumns) {
        this.iColumns = iColumns;
    }

    public String getsColumns() {
        return this.sColumns;
    }

    public void setsColumns(String sColumns) {
        this.sColumns = sColumns;
    }

    public int getiSortingCols() {
        return this.iSortingCols;
    }

    public void setiSortingCols(int iSortingCols) {
        this.iSortingCols = iSortingCols;
    }

    public int getSortColIndex() {
        return this.iSortCol_0.intValue();
    }

    public void setiSortCol_0(Integer iSortCol_0) {
        this.iSortCol_0 = iSortCol_0;
    }

    public String getSortColDir() {
        return this.sSortDir_0;
    }

    public void setsSortDir_0(String sSortDir_0) {
        this.sSortDir_0 = sSortDir_0;
    }
}

package PDF;

import java.util.List;

/**
 * Created by zhangzhaoyang on 2017/2/11.
 */
public class PDFInputTable<T> {

    private String[] titles;

    private String[] fields;

    private List<T> data;

    PDFCellStyleConfig sytleConfig = PDFCellStyleConfig.defaultConfig();

    public PDFInputTable() {
    }

    public PDFInputTable(String[] titles, String[] fields, List<T> data) {
        this.titles = titles;
        this.fields = fields;
        this.data = data;
    }

    public PDFInputTable(String[] titles, String[] fields, List<T> data, PDFCellStyleConfig sytleConfig) {
        this.titles = titles;
        this.fields = fields;
        this.data = data;
        this.sytleConfig = sytleConfig;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PDFCellStyleConfig getSytleConfig() {
        return sytleConfig;
    }

    public void setSytleConfig(PDFCellStyleConfig sytleConfig) {
        this.sytleConfig = sytleConfig;
    }
}

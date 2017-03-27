package PDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;

/**
 * pdf单元样式设置配置
 * Created by daiwei on 2017/2/11.
 */
public class PDFCellStyleConfig {

    private float setSpacingBefore = 50;

    private BaseColor headerColor = new BaseColor(255, 255, 255);
    private BaseColor headerBgColor = new BaseColor(111, 169, 189);
    private BaseColor headerBorderColor = new BaseColor(204, 204, 204);
    private int headerBorder = Rectangle.BOX;
    private float headerFontSize = 12;

    private BaseColor cellColor = new BaseColor(0, 0, 0);
    private BaseColor cellBgColor = new BaseColor(255, 255, 255);
    //单元格边界类型
    private int cellBorder = Rectangle.BOX;
    private BaseColor cellBorderColor = new BaseColor(204, 204, 204);
    private float cellFontSize = 10;

    public PDFCellStyleConfig() {
    }

    public PDFCellStyleConfig(float setSpacingBefore, BaseColor headerColor,
                              BaseColor headerBgColor,
                              BaseColor headerBorderColor,
                              int headerBorder,
                              float headerFontSize,
                              BaseColor cellColor,
                              BaseColor cellBgColor,
                              int cellBorder,
                              BaseColor cellBorderColor,
                              float cellFontSize) {
        this.setSpacingBefore = setSpacingBefore;
        this.headerColor = headerColor;
        this.headerBgColor = headerBgColor;
        this.headerBorderColor = headerBorderColor;
        this.headerBorder = headerBorder;
        this.headerFontSize = headerFontSize;
        this.cellColor = cellColor;
        this.cellBgColor = cellBgColor;
        this.cellBorder = cellBorder;
        this.cellBorderColor = cellBorderColor;
        this.cellFontSize = cellFontSize;
    }

    public static PDFCellStyleConfig defaultConfig(){
        return new PDFCellStyleConfig();
    }

    public float getSetSpacingBefore() {
        return setSpacingBefore;
    }

    public void setSetSpacingBefore(float setSpacingBefore) {
        this.setSpacingBefore = setSpacingBefore;
    }

    public BaseColor getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(BaseColor headerColor) {
        this.headerColor = headerColor;
    }

    public BaseColor getHeaderBgColor() {
        return headerBgColor;
    }

    public void setHeaderBgColor(BaseColor headerBgColor) {
        this.headerBgColor = headerBgColor;
    }

    public int getHeaderBorder() {
        return headerBorder;
    }

    public void setHeaderBorder(int headerBorder) {
        this.headerBorder = headerBorder;
    }

    public BaseColor getHeaderBorderColor() {
        return headerBorderColor;
    }

    public void setHeaderBorderColor(BaseColor headerBorderColor) {
        this.headerBorderColor = headerBorderColor;
    }

    public float getHeaderFontSize() {
        return headerFontSize;
    }

    public void setHeaderFontSize(float headerFontSize) {
        this.headerFontSize = headerFontSize;
    }

    public BaseColor getCellColor() {
        return cellColor;
    }

    public void setCellColor(BaseColor cellColor) {
        this.cellColor = cellColor;
    }

    public BaseColor getCellBgColor() {
        return cellBgColor;
    }

    public void setCellBgColor(BaseColor cellBgColor) {
        this.cellBgColor = cellBgColor;
    }

    public int getCellBorder() {
        return cellBorder;
    }

    public void setCellBorder(int cellBorder) {
        this.cellBorder = cellBorder;
    }

    public BaseColor getCellBorderColor() {
        return cellBorderColor;
    }

    public void setCellBorderColor(BaseColor cellBorderColor) {
        this.cellBorderColor = cellBorderColor;
    }

    public float getCellFontSize() {
        return cellFontSize;
    }

    public void setCellFontSize(float cellFontSize) {
        this.cellFontSize = cellFontSize;
    }



}

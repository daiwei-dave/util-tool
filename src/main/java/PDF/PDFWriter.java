package PDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangzhaoyang on 2017/2/11.
 */
public class PDFWriter {

    public static <T> void writePDFTables(List<PDFInputTable<T>> tables, DateFormat dateFormat, HttpServletResponse response) throws Exception {
        //①建立Document对象的实例。
        Document document = new Document();
       // ②建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        PdfWriter.getInstance(document, response.getOutputStream());
        //③打开文档。
        document.open();
        //中文处理，可以让文档中使用中文
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                BaseFont.NOT_EMBEDDED);
        //设置中文字体属性
        Font fontChinese = new Font(bfChinese, 10, Font.NORMAL);

        for (PDFInputTable inputTable : tables) {
            //表格处理
            PdfPTable table = new PdfPTable(inputTable.getTitles().length);
            //Sets the spacing before this table. 设置表前间距
            table.setSpacingBefore(inputTable.getSytleConfig().getSetSpacingBefore());
            //添加title
            for (String title : inputTable.getTitles()) {
                //pdf单元格
                PdfPHeaderCell cell = new PdfPHeaderCell();
                //设置title颜色
                fontChinese.setColor(inputTable.getSytleConfig().getHeaderColor());
                fontChinese.setSize(inputTable.getSytleConfig().getHeaderFontSize());
                //Adds an iText element to the cell.向单元格中添加元素
                cell.addElement(new Paragraph(title, fontChinese));
                //设置title单元格样式，包括背景颜色，边界
                cell.setBackgroundColor(inputTable.getSytleConfig().getHeaderBgColor());
                cell.setBorder(inputTable.getSytleConfig().getHeaderBorder());
                cell.setBorderColor(inputTable.getSytleConfig().getHeaderBorderColor());
                //Adds a cell element.向表格中添加单元格
                table.addCell(cell);
            }

            for (Object t : inputTable.getData()) {//遍历每一行
                Class userCla = (Class) t.getClass();
                //添加fields
                for (String field : inputTable.getFields()) {//遍历每一行中的每一个元素
                    //返回一个 Field 对象，该对象反映此 Class 对象所表示的类或接口的指定已声明字段。
                    Field f = userCla.getDeclaredField(field);
//                    A value of {@code true} indicates that
//     * the reflected object should suppress Java language access
//     * checking when it is used.  A value of {@code false} indicates
//                            * that the reflected object should enforce Java language access checks.
                    f.setAccessible(true); //设置些属性是可以访问的
                    Object val = f.get(t);//得到此属性的值
                    fontChinese.setColor(inputTable.getSytleConfig().getCellColor());
                    PdfPCell cell = new PdfPCell();
                    cell.setBorder(inputTable.getSytleConfig().getCellBorder());
                    cell.setBorderColor(inputTable.getSytleConfig().getCellBorderColor());
                    //日期字段单独格式化处理
                    if (val instanceof Date) {//val如果是Date类型
                        if (null == dateFormat) {
                            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        }
                        cell.addElement(new Paragraph(dateFormat.format(val), fontChinese));
                        table.addCell(cell);
                        continue;
                    }
                    if(val==null)
                        val="";
                    cell.addElement(new Paragraph(String.valueOf(val), fontChinese));
                    table.addCell(cell);
                }
            }
            //④向文档中添加内容
            document.add(table);
        }
        //⑤关闭文档。
        document.close();
    }
}

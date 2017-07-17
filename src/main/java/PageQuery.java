/**
 * Created by daiwei on 2017/7/14.
 * 分页类
 */
public class PageQuery {
    // 当前第几页
    private int pageNumber;

    // 查询数据库里面对应的数据有多少条
    private int totalRecords;// 从数据库查处的总记录数

    // 当前页显示的数目
    private int pageSize;

    //总页数
    private int totalPage;


    // 下页
    private int next;

    // 最后一页
    private int last;

    private int lpage;

    private int rpage;

    //从哪条开始查
    private int start;

    //到哪里结束
    private int end;



    public PageQuery() {
        super();
    }



    /****
     *
     * @param pageNumber
     * @param totalRecords
     * @param pageSize
     * 可以获得总页数，当前页，当前第几页
     */
    public void setCurrentpage(int pageNumber,int totalRecords,int pageSize) {
        //如果整除表示正好分N页，如果不能整除在N页的基础上+1页
        int totalPages = totalRecords%pageSize==0? totalRecords/pageSize : (totalRecords/pageSize)+1;

        //总页数
        this.totalPage = totalPages;

        //判断当前页是否越界,如果越界，我们就查最后一页
        if(pageNumber>totalPages){
            this.pageNumber = totalPages;
        }else{
            this.pageNumber=pageNumber;
        }
        if(pageNumber<=0){
            this.pageNumber=1;
        }

        //计算start   1----0    2  ------ 5
        this.start = (this.pageNumber-1)*pageSize;
        this.end=start+pageSize;
    }

    /****
     *
     * @param totalRecords   总记录数
     * @param pageNumber    当前页
     * @param pageSize    每页显示多少条
     *
     *  可以获得总记录数，当前页显示的数目，
     */
    public PageQuery(int totalRecords,int pageNumber,int pageSize) {
        //总记录数
        this.totalRecords = totalRecords;
        //每页显示多少条
        this.pageSize=pageSize;

        //计算当前页和数据库查询起始值以及总页数
        setCurrentpage(pageNumber, totalRecords, pageSize);

        //分页计算
        int leftcount =5,    //需要向上一页执行多少次
                rightcount =4;
        //起点页
        this.lpage =pageNumber;
        //结束页
        this.rpage =pageNumber;

        //2点判断
        this.lpage = pageNumber-leftcount;            //正常情况下的起点
        this.rpage = pageNumber+rightcount;        //正常情况下的终点

        //页差=总页数和结束页的差
        int topdiv = this.last-rpage;                //判断是否大于最大页数

        /***
         * 起点页
         * 1、页差<0  起点页=起点页+页差值
         * 2、页差>=0 起点和终点判断
         */
        this.lpage=topdiv<0? this.lpage+topdiv:this.lpage;

        /***
         * 结束页
         * 1、起点页<=0   结束页=|起点页|+1
         * 2、起点页>0    结束页
         */
        this.rpage=this.lpage<=0? this.rpage+(this.lpage*-1)+1: this.rpage;

        /***
         * 当起点页<=0  让起点页为第一页
         * 否则不管
         */
        this.lpage=this.lpage<=0? 1:this.lpage;

        /***
         * 如果结束页>总页数   结束页=总页数
         * 否则不管
         */
        this.rpage=this.rpage>last? this.last:this.rpage;
    }




    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    public int getNext() {
        return  pageNumber<last? pageNumber+1: last;
    }


    //上一页
    public int getUpper() {
        return pageNumber>1? pageNumber-1: pageNumber;
    }

    public int getLast() {
        return last;
    }

    //总共有多少页，即末页
    public void setLast(int last) {
        this.last = totalRecords%pageSize==0? totalRecords/pageSize : (totalRecords/pageSize)+1;
    }


    public int getLpage() {
        return lpage;
    }

    public void setLpage(int lpage) {
        this.lpage = lpage;
    }

    public int getRpage() {
        return rpage;
    }

    public void setRpage(int rpage) {
        this.rpage = rpage;
    }

    public int getStart() {
        return start;
    }

}

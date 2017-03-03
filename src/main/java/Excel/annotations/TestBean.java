package Excel.annotations;

/**
 * Created by zhangzhaoyang on 2016/11/9.
 */
public class TestBean {

    @ExcelField(title = "姓名", align = 1, sort = 1,property="name")
    private String name;

    @ExcelField(title = "昵称", align = 1, sort = 2,property="nickName")
    private String nickName;

    public TestBean(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

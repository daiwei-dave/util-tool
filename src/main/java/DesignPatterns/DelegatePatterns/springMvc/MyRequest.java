package DesignPatterns.DelegatePatterns.springMvc;

/**
 * @author daiwei
 * @date 2018/8/28 11:21
 */
public class MyRequest {

    private String requestURI;


    private String parameter;



    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}

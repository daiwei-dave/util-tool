package platform.framework.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * @Description
 * @Author zhangliewei
 * @Date 2017/2/7
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class FreemarkerExceptionHandler implements TemplateExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(FreemarkerExceptionHandler.class);

    public void handleTemplateException(TemplateException te, Environment environment, Writer writer) throws TemplateException {
        log.warn("[Freemarker Error: " + te.getMessage() + "]");
        if (!environment.isInAttemptBlock()) {
            PrintWriter printWriter = writer instanceof PrintWriter ? (PrintWriter) writer : new PrintWriter(writer);
            printWriter.print("FreeMarker template error (DEBUG mode; use RETHROW in production!):\n");
            printWriter.flush();
        } else {
            log.error("is in attempt block, environment=" + environment);
        }
    }
}

package Tag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class GreetTag  extends BodyTagSupport{
    private int count;

    /**
     *只有当doStartTag()方法的返回值是EVAL_BODY_BUFFERED时，
     *JSP页面的实现对象才会创建BodyContent对象，
     *调用setBodyContent()和doInitBody()方法。
     */
    public int doStartTag() throws JspException
    {
        count=0;
        return EVAL_BODY_BUFFERED;
    }

    /**
     *因为在doAfterBody()方法被调用之前，标记体已经被执行过一次，
     *所以在这里虽然是两次循环，但实际上会输出三段标记体的内容。
     */
    public int doAfterBody() throws JspException
    {
        if(count<2)
        {
            count++;
            return EVAL_BODY_AGAIN;
        }
        else
        {
            return SKIP_BODY;
        }
    }

    public int doEndTag() throws JspException
    {
        JspWriter out=bodyContent.getEnclosingWriter();
        try
        {
            out.println(bodyContent.getString());

        }
        catch(IOException e)
        {
            System.err.println(e);
        }
        return EVAL_PAGE;
    }
}

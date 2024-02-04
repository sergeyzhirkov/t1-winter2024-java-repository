import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/help-service/v1/support")
public class MyHttpServlet extends HttpServlet {
    private static final CopyOnWriteArrayList<String> phraseList = new CopyOnWriteArrayList<>();

    // for tests
    public static int getPhraseListSize() {
        return phraseList.size();
    }

    static {
        phraseList.add("testPhrase1");
        phraseList.add("testPhrase2");
        phraseList.add("testPhrase3");
    }

    private void setResponseParams(HttpServletResponse resp) {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseParams(resp);
        int index = (int) (Math.random() * phraseList.size());
        resp.getWriter().println(phraseList.get(index));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseParams(resp);
        phraseList.add(req.getReader().readLine());
    }
}

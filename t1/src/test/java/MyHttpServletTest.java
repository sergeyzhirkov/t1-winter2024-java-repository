import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import static org.mockito.Mockito.*;

class MyHttpServletTest {
    private MyHttpServlet servlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private StringWriter respWriter;

    @BeforeEach
    void setUp() throws IOException {
        servlet = new MyHttpServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        respWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(respWriter);
        when(resp.getWriter()).thenReturn(writer);
    }

    @Test
    void testDoGet() throws ServletException, IOException {
        servlet.doGet(req, resp);

        Assertions.assertTrue(respWriter.toString().contains("testPhrase"));
    }

    @Test
    void testDoPost() throws ServletException, IOException {
        StringReader stringReader = new StringReader("testPhrase4");
        when(req.getReader()).thenReturn(new BufferedReader(stringReader));

        servlet.doPost(req, resp);

        Assertions.assertEquals(4, MyHttpServlet.getPhraseListSize());
    }
}
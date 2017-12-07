package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/XoaDeTai")
public class XoaDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public XoaDeTai() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	Integer madetai = Integer.valueOf(request.getParameter("madetai"));

	Connection c = null;

	try {
		c = connect.DBConnect.getConnection();
	    String sql = "delete from detai where madetai =" + madetai;

	    // Use PreparedStstement to get sql' code
	    PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
	    pstmt.executeUpdate();
	} catch (Exception e) {
	    throw new ServletException(e);
	}

	finally {
	    try {
		if (c != null)
		    c.close();
	    } catch (Exception e) {
		throw new ServletException(e);
	    }
	}
	response.sendRedirect("detai");
    }
}

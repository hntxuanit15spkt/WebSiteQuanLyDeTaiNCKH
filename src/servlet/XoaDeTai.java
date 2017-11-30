package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class XoaDeTai
 */
@WebServlet("/XoaDeTai")
public class XoaDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDeTai() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String maDeTai = request.getParameter("id");
	Connection c = null;
	try {
	    String url = "jdbc:mysql://localhost/quanlydetainghiencuukhoahoc?user=root&password=15110376";
	    c = (Connection) DriverManager.getConnection(url);
	    String sqlStr = "delete from detai where MaDeTai=?";
	    PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sqlStr);
	    pstmt.setString(1, maDeTai);
	    pstmt.executeUpdate();
	    response.sendRedirect("HienThiDeTai");

	} catch (SQLException e) {
	    throw new ServletException(e);
	} finally {
	    try {
		if (c != null) {
		    c.close();
		}
	    } catch (SQLException e) {
		throw new ServletException(e);
	    }
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

}

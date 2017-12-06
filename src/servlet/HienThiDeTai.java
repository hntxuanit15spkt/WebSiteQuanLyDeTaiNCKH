package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.DeTai;

/**
 * Servlet implementation class HienThiDeTai
 */
@WebServlet("/HienThiDeTai")
public class HienThiDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
	super.init(config);
	try {
	    Class.forName("com.mysql.jdbc.Driver");// initialize jdbc driver
	} catch (ClassNotFoundException e) {
	    throw new ServletException(e);
	}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<DeTai> lstDeTai = new ArrayList<DeTai>();
	Connection c = null;
	try {
	    String url = "jdbc:mysql://localhost/quanlydetainghiencuukhoahoc?user=root&password=15110376";
	    c = (Connection) DriverManager.getConnection(url);
	    Statement stmt = (Statement) c.createStatement();
	    ResultSet rs = stmt.executeQuery("select * from detai order by madetai");
	    while (rs.next()) {
		DeTai dt = new DeTai(rs.getInt("MaDeTai"), rs.getString("TenDeTai"), rs.getString("PhuongPhapThucHien"),
			rs.getString("KinhPhi"), rs.getString("LoaiDeTai"));
		lstDeTai.add(dt);
	    }
	    request.setAttribute("DeTai", lstDeTai);
	    request.getRequestDispatcher("/WEB-INF/testHienThiDeTaiJDBC.jsp").forward(request, response);
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

}

package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DangKyDeTai")
public class DangKyDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyDeTai() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	/*
	 * List<BoMon> listBomon = new ArrayList<BoMon>(); Connection c = null; try { //
	 * String url = //
	 * "jdbc:mysql://localhost/quanlydetainghiencuukhoahoc?user=root&password=15110376";
	 * // c = (Connection) DriverManager.getConnection(url); c =
	 * connect.DBConnect.getConnection(); Statement stmt = (Statement)
	 * c.createStatement(); ResultSet rs = stmt.executeQuery("select * from bomon");
	 * while (rs.next()) { BoMon bomon = new BoMon(rs.getInt("MaBoMon"),
	 * rs.getString("TenBoMon"), rs.getInt("MaTruongBoMon")); listBomon.add(bomon);
	 * } } catch (SQLException e) { throw new ServletException(e); } finally { try {
	 * if (c != null) { c.close(); } } catch (SQLException e) { throw new
	 * ServletException(e); } }
	 */
	// request.setAttribute("listBomon", listBomon);
	request.getRequestDispatcher("/WEB-INF/dangkydetai1.jsp").forward(request, response);
    }

}

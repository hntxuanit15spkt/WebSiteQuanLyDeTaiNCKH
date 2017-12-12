package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/GVDanhGiaPhanBien")
public class GVDanhGiaPhanBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GVDanhGiaPhanBien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			
			// Accept
			
			Integer madetai = Integer.valueOf(request.getParameter("madetai"));
			
			Connection c = null;
			
			try {
				c = connect.DBConnect.getConnection();
				String sql = "insert into detai_trangthai (MaDeTai, MaTrangThai, ThoiGianThayDoi) values (" + madetai + ", 8, curdate())";
				PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
			    pstmt.executeUpdate();

			}
			catch (Exception e) {
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
			response.sendRedirect("DanhGiaPhanBien");
		}
		else response.sendRedirect("dangnhap");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			
			// Refuse
			
			Integer madetai = Integer.valueOf(request.getParameter("madetai"));
			
			Connection c = null;
			
			try {
				c = connect.DBConnect.getConnection();
				String sql = "insert into detai_trangthai (MaDeTai, MaTrangThai, ThoiGianThayDoi) values (" + madetai + ", 7, curdate())";
				PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
			    pstmt.executeUpdate();

			}
			catch (Exception e) {
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
			response.sendRedirect("DanhGiaPhanBien");
		}
		else response.sendRedirect("dangnhap");
	}

}

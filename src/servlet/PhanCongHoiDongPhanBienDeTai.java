package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataAccessObject.PhanCongHoiDongPhanBien_DAO;

/**
 * Servlet implementation class PhanCongHoiDongPhanBienDeTai
 */
@WebServlet("/PhanCongHoiDongPhanBienDeTai")
public class PhanCongHoiDongPhanBienDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhanCongHoiDongPhanBienDeTai() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();
	PhanCongHoiDongPhanBien_DAO phanCongHoiDongPhanBien = new PhanCongHoiDongPhanBien_DAO();
	String username = (String) session.getAttribute("username");
	String tenHoiDongPhanBien = (String) request.getParameter("tenhoidongphanbien");
	String maLoaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	String[] lstGiangVien = request.getParameterValues("giangvien");
	if (username != null && maLoaiNguoiDung.equals("5")) {
	    for (int i = 0; i < lstGiangVien.length; i++) {
		phanCongHoiDongPhanBien.TaoHoiDongVaThemGiangVien(tenHoiDongPhanBien,
			Integer.parseInt(lstGiangVien[i]));
	    }
	    int maDeTai = Integer.parseInt(request.getParameter("maDeTai_PhanCongPhanBien"));
	    phanCongHoiDongPhanBien.CapNhatDeTai(maDeTai);
	    response.sendRedirect("trangchu");
	} else {
	    response.sendRedirect("dangnhap");
	}
    }

}

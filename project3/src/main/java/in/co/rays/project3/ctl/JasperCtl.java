package in.co.rays.project3.ctl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.SessionImpl;

import in.co.rays.project3.dto.UserDTO;
import in.co.rays.project3.util.HibDataSource;
import in.co.rays.project3.util.JDBCDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Jasper functionality Controller. Performs operation for Print pdf of
 * MarksheetMeriteList
 * 
 * @author computer gallery
 *
 */
@WebServlet(name = "JasperCtl", urlPatterns = { "/ctl/JasperCtl" })
public class JasperCtl extends BaseCtl{

	/**
	 * The doGet Method
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	try {
	 /*Compilation of jrxml file */

	JasperReport jasperReport = JasperCompileManager.compileReport(
			"E:\\P3\\project3\\src\\main\\webapp\\jasper\\Blank_A4.jrxml");


	HttpSession session = request.getSession(true);
	UserDTO dto = (UserDTO) session.getAttribute("user");
	dto.getFirstName();
	dto.getLastName();

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("ID", 1l);
	java.sql.Connection conn = null;

	ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project3.bundle.system");

	String Database = rb.getString("DATABASE");
	if ("Hibernate".equalsIgnoreCase(Database)) {
	conn = ((SessionImpl) HibDataSource.getSession()).connection();
	}

	if ("JDBC".equalsIgnoreCase(Database)) {
	conn = JDBCDataSource.getConnection();
	}

	 /*Filling data into the report */
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);

	/* Export Jasper report*/ 
	byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

	response.setContentType("application/pdf");
	response.getOutputStream().write(pdf);
	response.getOutputStream().flush();
	} catch (Exception e) {

	}
	}

	/**
	 * The doPost Method
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	/**
	 * The getView Method
	 */
	@Override
	protected String getView() {
	return null;
	}
}

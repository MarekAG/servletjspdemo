package com.example.servletjdom.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletdom.domain.Dom;
import com.example.servletdom.service.DomService;

@WebServlet(urlPatterns = "/dom")
public class DomServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String start = "<html><head><title>Dom</title><link rel='stylesheet' type='text/css' href='style.css'></head><body><div id='site'><div id='content'>";
	private String stop = "</div></div></body></html>";
	private final String backButton = "<div id='backBtn'><form action='dom'>"
			+ "<input type='submit' value='Powrót'>" + "</form></div>";
	DomService service = new DomService();
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String loggedUser = session.getAttribute("test") != null ? "<p>"+session.getAttribute("test")+"</p>" : "";
		
		if ("add".equals(request.getParameter("action"))) {
			PrintWriter pw = response.getWriter();
			pw.println(start+loggedUser);
			pw.print("<h2>Podaj parametry nowego domu: </h2>"
					+ "<div id='form'><form action='dom' method='POST'>"
					+ "<label>Metraż (m<sup>2</sup>):</label> <select name='size'>");
			for (int i = 20; i <= 200; i += 20) {
				pw.print("<option value='" + i + "'>" + i + "</option>");
			}
			pw.println("</select><br/>"
					+ "<label>Adres:</label> <input type='text' name='address' required/> <br />"
					+ "<label>Ilosć drzwi:</label> <input type='number' name='nrOfDoors' min='1' value='1' required/> <br />"
					+ "<label>Ilość pięter:</label> <input type='number' name='nrOfFloors' min='1' max='200' value='1' required/> <br />"
					+ "<label>Kolor:</label>"
					+ "<div id='radioBtns'><input type='radio' name='color' value='biały' checked>Biały <br />"
					+ "<input type='radio' name='color' value='niebieski'>Niebieski <br />"
					+ "<input type='radio' name='color' value='brązowy'>Brązowy <br />"
					+ "<input type='radio' name='color' value='czerwony'>Czerwony <br />"
					+ "<input type='radio' name='color' value='żółty'>Żółty <br /></div>"
					+ "<label>Rok budowy:</label> <input type='number' min='0' max='2014' name='yoc' value='2014' required/> <br />"
					+ "<label>Zdjęcie (URL):</label> <input type='url' name='imageUrl'> <br />"
					+ "<input type='submit' value=' Zapisz ' />"
					+ "</form></div>");
			pw.println(backButton);
			pw.println(stop);
			pw.close();
		} else if ("showAll".equals(request.getParameter("action"))) {
			if (service.showAll().size() == 0) {
				PrintWriter pw = response.getWriter();
				pw.println("<script>" + "alert('Brak domów do wyświetlenia'); "
						+ "window.location.replace('dom');" + "</script>");
				pw.close();
				response.sendRedirect("http://localhost:8080/servletdom/dom");
			} else {
				PrintWriter pw = response.getWriter();
				pw.println(start+loggedUser);
				pw.println("<ul>");
				List<Dom> houses = service.showAll();
				for (int i = 0; i < service.showAll().size(); i++) {
					pw.println("<li>" + houses.get(i));
					pw.println("<form action='dom' method='POST'>"
							+ "<input type='hidden' name='index' value='" + i
							+ "'/>" + "<input type='submit' value=' Usuń ' />"
							+ "</form></li><br/>");
				}
				pw.println("</ul>");
				pw.println(backButton);
				pw.println(stop);
				pw.close();
			}
		} else {
			PrintWriter pw = response.getWriter();
			pw.println(start+loggedUser);
			pw.println("<h2>Wybierz co chcesz zrobić: </h2>"
					+ "<ul><li><a href='dom?action=add'>Dodaj nowy dom</a></li><br/>"
					+ "<li><a href='dom?action=showAll'>Wyświetl wszystkie domy</a></li><br/>"
					+ "<li><a href='dom?action=removeAll'>Usuń wszystkie domy</a></li></ul>");

			if ("removeAll".equals(request.getParameter("action"))) {
				pw = response.getWriter();
				pw.println("<script>"
						+ "var deleteAll = confirm('Usunąć wszystkie rekordy?');"
						+ "if(deleteAll) {"
						+ "var form = document.createElement('form');"
						+ "form.setAttribute('method','post');"
						+ "form.setAttribute('action','dom');"
						+ "var element = document.createElement('input');"
						+ "element.setAttribute('type', 'hidden'); "
						+ "element.setAttribute('name', 'deleteAll'); "
						+ "element.setAttribute('value', 'true'); "
						+ "form.appendChild(element); " + "form.submit(); "
						+ " alert('Usunięto! Brak domów w bazie.');" + " }"
						+ "else " + "window.location.replace('dom');"
						+ "</script>");
			}
			pw.println(stop);
			pw.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		if (request.getParameter("index") != null) {
			service.remove(Integer.parseInt(request.getParameter("index")));
			response.sendRedirect("http://localhost:8080/servletdom/dom?action=showAll");
		} else if ("true".equals(request.getParameter("deleteAll"))) {
			service.removeAll();
			response.sendRedirect("http://localhost:8080/servletdom/dom");
		} else {
			Dom dom = new Dom();
			dom.setSize(Integer.parseInt(request.getParameter("size")));
			dom.setAddress(request.getParameter("address"));
			dom.setNrOfDoors(Integer.parseInt(request.getParameter("nrOfDoors")));
			dom.setNrOfFloors(Integer.parseInt(request
					.getParameter("nrOfFloors")));
			dom.setColor(request.getParameter("color"));
			dom.setYoc(Integer.parseInt(request.getParameter("yoc")));
			dom.setImageUrl(request.getParameter("imageUrl"));
			service.add(dom);

			PrintWriter pw = response.getWriter();
			pw.println(start);
			pw.println(dom);
			pw.println(backButton);
			pw.println(stop);
			pw.close();
		}

	}

}

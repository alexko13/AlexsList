package client;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcessListings")
public class ProcessListingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServletContext context;

	@Override
	public void init() throws ServletException {
		context = getServletContext();
		context.setAttribute("allListings", new ArrayList<String>());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<String> allListings = (ArrayList<String>) context.getAttribute("allListings");
			String listing = request.getParameter("listing");
			
			if (listing != null) {
				allListings.add(listing);
			}
			
			forwardToJSP(request, response, "/DisplayListings.jsp");
		} catch (Exception e) {
			request.setAttribute("exception", e);
			forwardToJSP(request, response, "/Error.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void forwardToJSP(HttpServletRequest request, HttpServletResponse response, String jsp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}
}

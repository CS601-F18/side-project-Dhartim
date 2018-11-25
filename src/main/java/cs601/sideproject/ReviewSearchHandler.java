package cs601.sideproject;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

/**
 * ReviewSearchHandler - will handle get and post request and response of reviewsearch application
 * @author dhartimadeka
 *
 */
@SuppressWarnings("serial")
public class ReviewSearchHandler extends HttpServlet
{
	
	private List<String> autocomplete;
	private Logger logger = LogManager.getLogger(ReviewSearchHandler.class);
	/**
	 * doGet- handles get request, response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		InvertedIndexInitilizer initilizer = InvertedIndexInitilizer.getInstance();
		autocomplete = initilizer.getInvertIndexReview().getKeyset();
		logger.info("Keyset from review inverted index is successfully created");
		Gson gson = new Gson();
		String jsonList = gson.toJson(autocomplete);
		logger.info("read data into json");
		String scriptForAuto = JavaScriptElements.JS_AUTOCOMPLETE.replace("{keysetauto}", jsonList);
		logger.info("Replace {keysetauto} with keylist generated");
		String updatedHtml = HtmlPages.HTML_REVIEW_SEARCH_FORM.replace("{autocompletejs}", scriptForAuto);
		PrintWriter out = response.getWriter();
		out.print(updatedHtml);
		logger.info("GET page response was successful");
	}
	/**
	 * handles post request, response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String query = request.getParameter("query");
		InvertedIndexInitilizer initilizer = InvertedIndexInitilizer.getInstance();
		System.out.println(query);
		List<String> result = initilizer.getInvertIndexReview().searchterm(query);
		logger.info("Data given is searched from inverted index");
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		String tablerow="";
		for(String eachrow : result)
		{
			tablerow+= eachrow;
		}
		String htmlpage = HtmlPages.HTML_SEARCH_RESULT.replace("{tableBody}", tablerow);
		PrintWriter out = response.getWriter();
		out.println(htmlpage);
		logger.info("POST page response was successful");
		
	}
}
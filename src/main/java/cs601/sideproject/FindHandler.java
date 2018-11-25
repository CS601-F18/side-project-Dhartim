package cs601.sideproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//import org.jsoup.Jsoup;

//import cs601.project1.*;
/**
 * findHandler - handles findApplication
 * @author dhartimadeka
 *
 */
@SuppressWarnings("serial")
public class FindHandler extends HttpServlet
{
	private List<String> autocomplete;
	/**
	 * handles get request
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		InvertedIndexInitilizer initilizer = InvertedIndexInitilizer.getInstance();
		autocomplete = initilizer.getInvertIndexReview().getAsinKeySet();
		Gson gson = new Gson();
		String jsonList = gson.toJson(autocomplete);
		String scriptForAuto = JavaScriptElements.JS_AUTOCOMPLETE.replace("{keysetauto}", jsonList);
		String updatedHtml = HtmlPages.HTML_FIND_FORM.replace("{autocompletejs}", scriptForAuto);
		PrintWriter out = response.getWriter();
		out.print(updatedHtml);
	}
	/**
	 * handles post request
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String asinId = request.getParameter("asin");
		InvertedIndexInitilizer initilizer = InvertedIndexInitilizer.getInstance();
		System.out.println(asinId);
		List<String> result = initilizer.getInvertIndexReview().findAsin(asinId);
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		String tableRow ="";
		for(String eachrow : result)
		{
				tableRow += eachrow;
		}
		String htmlresult = HtmlPages.HTML_SEARCH_RESULT.replace("{tableBody}", tableRow);
		PrintWriter out = response.getWriter();
		out.write(htmlresult);
	}	
}
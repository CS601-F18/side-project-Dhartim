package cs601.sideproject;
/**
 * HtmlPages - Interface with html pages to implement as per response from server 
 * @author dhartimadeka
 *
 */
public interface HtmlPages 
{
	String HTML_405 = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"ISO-8859-1\" />\r\n" + 
			"<title>405</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"	<h1>405 BAD METHOD PASSED !!</h1>\r\n" + 
			"</body>\r\n" + 
			"</html>";

	String HTML_404 =  
			"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\" />\r\n" + 
					"<title>404</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<h1>404 Page Not found :(</h1>\r\n" + 
					"</body>\r\n" + 
					"</html>";

	String HTML_EMPTY_MANDATORY_FIELD = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"ISO-8859-1\"/>\r\n" + 
			"<title>404</title>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"	<h1>404 Page Not found :(</h1>\r\n" + 
			"</body>\r\n" + 
			"</html>";

	String HTML_FIND_FORM = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"ISO-8859-1\"/>\r\n" + 
			"<title>Find Asin</title>\r\n"+
			CSSElements.CSS_AUTOCOMPLETE  + 
			"</head>\r\n" + 
			"<body>\r\n"
			+ "<center>" +
			"<h1>Find Asin Search </h1>"+
			"	<form autocomplete='off' action='find' method='POST'>\r\n"
			+ 		"<div class=\"autocomplete\" style=\"width:300px;\">\r\n" + 
			"			Enter Asin : <input id=\"myInput\" type='text' name='asin' required='required' placeholder=\"Asin\"/><br/> \r\n" 
					+"</div> \r\n" +  
			"		<input type='submit' value='Submit' />\r\n" +
			"	</form>\r\n"
			+ "{autocompletejs}"
			+ "</center>" + 
			"</body>\r\n" + 
			"</html>";

	String HTML_REVIEW_SEARCH_FORM = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"ISO-8859-1\"/>\r\n" + 
			"<title>Review Search</title>\r\n" + 
			CSSElements.CSS_AUTOCOMPLETE +
			"</head>\r\n" + 
			"<body>\r\n"
			+ "<center>" + 
			"<h1>Review Search </h1>"+
			"	<form autocomplete=\"off\" action='reviewsearch' method='POST'> \r\n" + 
			"  <div class=\"autocomplete\" style=\"width:300px;\">\r\n" + 
			"    Enter text:  <input id=\"myInput\" type=\"text\" name='query' required='required' placeholder=\"Text\">\r\n" + 
			"  </div>\r\n" + 
			"  <input type='submit' value='Submit' />\r\n" + 
			"</form>" + 
			"{autocompletejs}"
			+ "</center>" +
			"</body>\r\n" + 
			"</html>";
	
	String HTML_SEARCH_RESULT = "<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"ISO-8859-1\">\r\n" + 
			"<title>Result</title>\r\n" + 
			CSSElements.CSS_SEARCH_RESULT +
			"<Script>\r\n" + 
			"{reload}\r\n" + 
			"</Script>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" +  
			"	<br />\r\n" + 
			"	<div>\r\n" + 
			"		<table id=\"reviewdata\">\r\n" + 
			"			<tr>\r\n" + 
			"				<th>Asin ID</th>\r\n" + 
			"				<th>Review Id/Question</th>\r\n" + 
			"				<th>Review Text/Answer</th>\r\n" + 
			"			</tr>\r\n" + 
			"			{tableBody}\r\n" + 
			"		</table>\r\n" + 
			"	</div>\r\n" + 
			"</body>\r\n" + 
			"</html>";
}

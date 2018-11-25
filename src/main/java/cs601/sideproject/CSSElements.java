package cs601.sideproject;
/**
 * CSS interface to hold css for auto search and search result.
 * @author dhartimadeka
 *
 */
public interface CSSElements {
	
	String CSS_SEARCH_RESULT = "<style>\r\n" + 
			"#reviewdata {\r\n" + 
			"	font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\r\n" + 
			"	border-collapse: collapse;\r\n" + 
			"	width: 100%;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#reviewdata td, #reviewdata th {\r\n" + 
			"	border: 1px solid #ddd;\r\n" + 
			"	padding: 8px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#reviewdata tr:nth-child(even) {\r\n" + 
			"	background-color: #f2f2f2;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"#reviewdata th {\r\n" + 
			"	padding-top: 12px;\r\n" + 
			"	padding-bottom: 12px;\r\n" + 
			"	text-align: left;\r\n" + 
			"	background-color: #4CAF50;\r\n" + 
			"	color: white;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"</style>";
	
	String CSS_AUTOCOMPLETE =
			"<style>\r\n" + 
			"* {\r\n" + 
			"  box-sizing: border-box;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"body {\r\n" + 
			"  font: 16px Arial;  \r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".autocomplete {\r\n" + 
			"  /*the container must be positioned relative:*/\r\n" + 
			"  position: relative;\r\n" + 
			"  display: inline-block;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"input {\r\n" + 
			"  border: 1px solid transparent;\r\n" + 
			"  background-color: #f1f1f1;\r\n" + 
			"  padding: 10px;\r\n" + 
			"  font-size: 16px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"input[type=text] {\r\n" + 
			"  background-color: #f1f1f1;\r\n" + 
			"  width: 100%;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"input[type=submit] {\r\n" + 
			"  background-color: green;\r\n" + 
			"  color: #fff;\r\n" + 
			"  cursor: pointer;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".autocomplete-items {\r\n" + 
			"  position: absolute;\r\n" + 
			"  border: 1px solid #d4d4d4;\r\n" + 
			"  border-bottom: none;\r\n" + 
			"  border-top: none;\r\n" + 
			"  z-index: 99;\r\n" + 
			"  /*position the autocomplete items to be the same width as the container:*/\r\n" + 
			"  top: 100%;\r\n" + 
			"  left: 0;\r\n" + 
			"  right: 0;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".autocomplete-items div {\r\n" + 
			"  padding: 10px;\r\n" + 
			"  cursor: pointer;\r\n" + 
			"  background-color: #fff; \r\n" + 
			"  border-bottom: 1px solid #d4d4d4; \r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".autocomplete-items div:hover {\r\n" + 
			"  /*when hovering an item:*/\r\n" + 
			"  background-color: #e9e9e9; \r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".autocomplete-active {\r\n" + 
			"  /*when navigating through the items using the arrow keys:*/\r\n" + 
			"  background-color: DodgerBlue !important; \r\n" + 
			"  color: #ffffff; \r\n" + 
			"}\r\n" + 
			"</style>";

}

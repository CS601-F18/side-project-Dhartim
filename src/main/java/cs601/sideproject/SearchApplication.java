package cs601.sideproject;
import javax.servlet.http.HttpServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * SearchApplication - main class of search application
 * @author dhartimadeka
 *
 */
public class SearchApplication extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Logger logger = LogManager.getLogger(SearchApplication.class);

	public static void main(String[] args) throws Exception {

		if(args.length != 1)
		{
			System.out.println("please specify configuration file name");
			logger.info("Configuration file missing");
			System.exit(0);
			
		}
		String ConfigFileName = args[0];
		logger.info("Configuration file is specified");
		SetUpInvertedIndex setUpInvertedIndex = SetUpInvertedIndex.getInstance(ConfigFileName);
		setUpInvertedIndex.initInvertedIndex();
		logger.info("Inverted index created successfully");
		Server server = new Server(8080);
		logger.info("Server created");
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);
		logger.info("Servlet handler set to server");
		handler.addServletWithMapping(ReviewSearchHandler.class, "/reviewsearch");
		handler.addServletWithMapping(FindHandler.class, "/find");
		logger.info("Mapping successful");
		logger.info("starting server");
		server.start();
		server.join();
	}
}
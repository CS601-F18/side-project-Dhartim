package cs601.sideproject;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cs601.project1.InvertedIndexBuilder;
import cs601.project1.AmazonSearch.typeOfFile;
import cs601.project1.InvertedIndex;
/**
 * SetUpInvertedIndex - Class to set up an inverted index
 * @author dhartimadeka
 *
 */
public class SetUpInvertedIndex 
{
	public static boolean isDataLoading = true;
	private static SetUpInvertedIndex instance;
	private String configurationFile;
	private ReadConfigurationFile readConfigfile = new ReadConfigurationFile();
	private ConfigurationBean configurationBuilder = new ConfigurationBean();
	private Logger logger = LogManager.getLogger(SetUpInvertedIndex.class);
	private SetUpInvertedIndex(String file) 
	{
		this.configurationFile = file;
	}
	
	/**
	 * getInstance - gives instance of an Invertedindex class
	 * @param file - pass configuration file
	 * @return
	 */
	public static SetUpInvertedIndex getInstance(String file) {
		if (instance == null) {
			instance = new SetUpInvertedIndex(file);
		}
		return instance;
	}
	
	/**
	 * initInvertedIndex - initializes inverted index and pass review and qa files path
	 * 
	 */
	public void initInvertedIndex() {
		
		InvertedIndexBuilder bds = new InvertedIndexBuilder();

		InvertedIndex invertedIndexforReview;
		InvertedIndex invertedIndexforQA;
		InvertedIndexInitilizer indexInitilizer = InvertedIndexInitilizer.getInstance();
		configurationBuilder = readConfigfile.readJsonFile(configurationFile);
		logger.info("Read Configuration file successfully");
		Path reviewFile = Paths.get(configurationBuilder.getreviewFile());
		Path qaFile = Paths.get(configurationBuilder.getqaFile());
		
		isDataLoading = true;
		invertedIndexforReview = bds.readFile(reviewFile, typeOfFile.Review); // create inverted index for review
		invertedIndexforQA = bds.readFile(qaFile, typeOfFile.QA); // create inverted index for QA.
		isDataLoading = false;

		indexInitilizer.setInvertIndexReview(invertedIndexforReview);
		indexInitilizer.setInvertIndexQA(invertedIndexforQA);
		logger.info("Inverted index of review and qasearch created successfully");

	}
}

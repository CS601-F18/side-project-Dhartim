package cs601.sideproject;
/**
 * CongirationBean - Class to get configuration.json elements into java objects.
 * @author dhartimadeka
 *
 */
public class ConfigurationBean 
{
	private String reviewFile;
	private String qaFile;
	
	public String getreviewFile() {
		return reviewFile;
	}
	public void setreviewFile(String reviewFile) {
		this.reviewFile = reviewFile;
	}
	public String getqaFile() {
		return qaFile;
	}
	public void setqaFile(String qaFile) {
		this.qaFile = qaFile;
	}
	
}

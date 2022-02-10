package in.co.rays.project3.dto;

/**
 * DropdownList interface is implemented by Beans those are used to create drop
 * down list on HTML pages
 * @author computer gallery
 *
 */
public interface DropdownList {

	/**
	 * return key of list element
	 * 
	 * @return
	 */
	public String getKey();

	
	/**
	 * display list of key element
	 * 
	 * @return
	 */
	public String getValue();
}

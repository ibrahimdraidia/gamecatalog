/*
 * Text box input verification.
 */
package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author GamyGate
 */
public class VerifyRegex
{
	private Pattern pattern;
	private Matcher matcher;
	private final int _id;
	private final String _toCheck;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Regex
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	private static final String DATE_PATTERN
			= "^[1-2][0-9][0-9][0-9]-[0-1][0-2]-[0-3][0-9]$";

	private static final String EMAIL_PATTERN
			= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String URL_PATTERN
			= "^(.*:)//([A-Za-z0-9\\-\\.]+)(:[0-9]+)?(.*)$";

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Constructor
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	/**
	 * Validate date with regular expression using id '1'
	 * validate that url is correctly entered with id '2' 
	 * validate that text does not exceed 1000 char with id '3'
	 * 
	 * @param id
	 * @param toCheck 
	 */
	public VerifyRegex(int id, String toCheck)
	{
		_id = id;
		_toCheck = toCheck;
	}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Tests
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
	public boolean validate()
	{
		switch (_id)
		{
			case 1:
				pattern = Pattern.compile(DATE_PATTERN);
				break;
			case 2:
				pattern = Pattern.compile(URL_PATTERN);
				break;
			case 3:
				if (_toCheck.length() > 1000)
					return false;
				break;
			default:
				break;
		}

		matcher = pattern.matcher(_toCheck);
		return matcher.matches();
	}
}

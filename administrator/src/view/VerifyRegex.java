/*
 * Text box input verification.
 */
package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author iain
 */
public class VerifyRegex
{
	private Pattern pattern;
	private Matcher matcher;
	private int _id;
	private String _toCheck;

	private static final String DATE_PATTERN =
			"^[1-2][0-9][0-9][0-9]-[0-1][0-2]-[0-3][0-9]$";

	private static final String EMAIL_PATTERN
			= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String URL_PATTERN
			= "^(.*:)//([A-Za-z0-9\\-\\.]+)(:[0-9]+)?(.*)$";

	public VerifyRegex(int id, String toCheck)
	{
		_id = id;
		_toCheck = toCheck;
	}

	/*
	 * Validate date with regular expression using '1'
	 * validate text does not depass 1000 char with 2.
	 */
	public boolean validate()
	{
		if (_id == 1)
		{
			pattern = Pattern.compile(DATE_PATTERN);
		}
		else if (_id == 2)
		{
			pattern = Pattern.compile(URL_PATTERN);
		}
		else if (_id == 3)
		{
			int i = _toCheck.length();
			if (i > 1000)
				return false;
		}

		matcher = pattern.matcher(_toCheck);
		return matcher.matches();
	}
}

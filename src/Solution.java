public class Solution
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		s.getLength("abcabcdede");

	}
	
	public int getLength(String s)
	{
		int answer = 0;

		answer = procString(s);

		return answer;
	}
	
	private void testGitHub()
	{
		
	}

	/**
	*  생성된 문자열의 크기를 비교 후 가장 작은 것을 리턴
	*/
	public int procString(String argString)
	{
		int intProc = 1000;

		for (int i = 1; i < argString.length(); i++)
		{
			int intLength = divString(argString, i);

			if (intProc > intLength)
			{
				intProc = intLength;
			}
		}

		return intProc;
	}

	/**
	* 문자열 생성하여 리턴
	*/
	public int divString(String argString, int intDiv)
	{
		int intLength = argString.length();

		int intStart = 0; 			// 문자열 자르기 시작 Point
		int intPoint = intDiv; 		// 문자열 자르기 끝 Point
		int intCount = 1; 			// 같은 문자열 Count

		String strSection = ""; 	// 자른 이전 문자열

		StringBuilder sbCompString = new StringBuilder();

		while (intPoint <= intLength)
		{
			String strTempSection = argString.substring(intStart, intPoint);
			
			if (strTempSection.equals(strSection))
			{
				intCount++;
			}
			else
			{
				if (strSection.equals(""))
				{
					strSection = strTempSection;
				}
				else
				{
					setCompString(sbCompString, intCount, strSection);
					
					strSection = strTempSection;
					intCount = 1;
				}
			}

			intStart = intPoint;
			intPoint = intStart + intDiv;
		}

		setCompString(sbCompString, intCount, strSection);
		
		if (intPoint > intLength)
		{
			String strTempSection = argString.substring(intStart, intLength);

			sbCompString.append(strTempSection);
		}

		intLength = sbCompString.toString().length();
		
		return intLength;
	}
	
	/**
	 * 압축 문자열 맵핑
	 */
	public void setCompString(StringBuilder sbCompString, int intCount, String strSection)
	{
		if (intCount == 1)
		{
			sbCompString.append(strSection);
		}
		else
		{
			sbCompString.append(intCount + strSection);
		}
	}

}
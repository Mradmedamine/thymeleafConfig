package com.mainsys.fhome.gui.dialect.expression;

import com.mainsys.fhome.gui.formatter.BebanFormatter;
import com.mainsys.fhome.gui.formatter.IbanFormatter;

public class AccountExpressionObject
{

	public String formatBeban(String beban)
	{
		return BebanFormatter.formatBeban(beban);
	}

	public static String formatIban(String iban)
	{
		return IbanFormatter.formatIban(iban);
	}

}

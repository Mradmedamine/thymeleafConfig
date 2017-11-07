package com.mainsys.fhome.gui.dialect.expression;

import java.util.Locale;

import com.mainsys.fhome.gui.formatter.AddressFormatter;
import com.mainsys.fhome.module.axa.base.model.branch.Branch;
import com.mainsys.fhome.module.base.model.core.Address;
import com.mainsys.fhome.module.base.model.core.Beneficiary;
import com.mainsys.fhome.module.base.model.core.CountryType;
import com.mainsys.fhome.module.directdebit.model.Operation;

public class AddressExpressionObject
{

	public String formatAddress(Address address)
	{
		return AddressFormatter.formatAddress(address);
	}

	public String formatAddress(String street, String city, CountryType countryType, Locale locale)
	{
		return AddressFormatter.formatAddress(street, city, countryType, locale);
	}

	public String getFormattedCity(Address address)
	{
		return AddressFormatter.getFormattedCity(address);

	}

	public String getFormattedStreet(Address address)
	{
		return AddressFormatter.getFormattedStreet(address);
	}

	// Beneficiary

	public static String getFormattedAddress(Beneficiary beneficiary, Locale locale)
	{
		return AddressFormatter.getFormattedAddress(beneficiary, locale);
	}

	public static String getFormattedAddress(Operation operation, Locale locale)
	{
		return AddressFormatter.getFormattedAddress(operation, locale);
	}

	// Branch
	public String getFormattedAddress(final Branch branch, final Locale locale)
	{
		return AddressFormatter.getFormattedAddress(branch, locale);
	}

	public static String getFormattedLocation(final Branch branch, final Locale locale)
	{
		return AddressFormatter.getFormattedLocation(branch, locale);
	}

}

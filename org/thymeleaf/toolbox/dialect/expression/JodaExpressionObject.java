package com.mainsys.fhome.gui.dialect.expression;

import java.util.GregorianCalendar;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import com.mainsys.fhome.gui.util.DateUtils;

public class JodaExpressionObject
{

	/**
	 * Create a new LocalDateTime object.
	 *
	 * @return New LocalDateTime object for the current time.
	 */
	public LocalDateTime createNow()
	{
		return new LocalDateTime();
	}

	/**
	 * Format any type of date object using Joda formatters.
	 *
	 * @param LocalDateTime
	 * @param pattern
	 * @return Formatted date/time string, or <tt>null</tt> if <tt>dateTime</tt> is also null.
	 */
	public String format(LocalDateTime dateTime, String pattern)
	{
		return dateTime != null ? DateTimeFormat.forPattern(pattern).print(dateTime) : null;
	}

	public LocalDateTime convert(GregorianCalendar calendar)
	{
		return DateUtils.convertToJODA(calendar);
	}

	public boolean between(LocalDate dateTime, LocalDate inf, LocalDate sup)
	{
		return dateTime != null && dateTime.isAfter(inf) && dateTime.isBefore(sup);
	}

}

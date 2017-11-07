package com.mainsys.fhome.gui.dialect.expression;

import java.text.DecimalFormat;

import com.mainsys.fhome.gui.util.NumberUtils;
import com.mainsys.fhome.module.base.model.core.CurrencyAmount;
import com.mainsys.fhome.module.base.model.core.DecimalNumber;

public class RateExpressionObject
{

	// NEW STRUCTURE

	// default formatters (max 2 digits after separator)

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link CurrencyAmount} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned. The formatted amount has
	 * 2 digits after the decimal separator.</p>
	 *
	 * <p>By default ' %' will be added as suffix.</p>
	 *
	 * @param number The number to format.
	 *
	 * @see NumberUtils#basicFormat(CurrencyAmount, Integer, Integer, String, String, boolean)
	 */
	public String format(CurrencyAmount number)
	{
		return NumberUtils.basicFormat(number, 2, 2, "", " %", false);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link DecimalNumber} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned. The formatted amount has
	 * 2 digits after the decimal separator.</p>
	 *
	 * <p>By default ' %' will be added as suffix.</p>
	 *
	 * @param number The number to format.
	 *
	 * @see NumberUtils#basicFormat(DecimalNumber, Integer, Integer, String, String, boolean)
	 */
	public String format(DecimalNumber number)
	{
		return NumberUtils.basicFormat(number, 2, 2, "", " %", false);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link DecimalNumber} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned. The formatted amount has
	 * 2 digits after the decimal separator.</p>
	 *
	 * <p>By default ' %' will be added as suffix.</p>
	 *
	 * @param number The number to format.
	 *
	 * @see NumberUtils#basicFormat(Number, Integer, Integer, String, String, boolean)
	 */
	public String format(Number number)
	{
		return NumberUtils.basicFormat(number, 2, 2, "", " %", false);
	}

	// formatters with specific min and max number of digits after decimal separator

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link Number} is null then an empty {@link String}
	 * is returned.</p>
	 *
	 * <p>By default ' %' will be added as prefix.</p>
	 *
	 * <p>If the minimum number of fractional digits is null or lower then 0, the 0 is used. In the same spirit if the
	 * maximum number of fractional digits is null or below zero then the maximum is 340 (see {@link DecimalFormat#setMaximumFractionDigits(int)}).</p>
	 *
	 * @param number The number to format.
	 * @param minfractionDigits The minimum number of digits of the decimal separator.
	 * @param maxfractionDigits The maximum number of digits of the decimal separator.
	 *
	 * @see NumberUtils#basicFormat(CurrencyAmount, Integer, Integer, String, String, boolean)
	 */
	public String format(CurrencyAmount number, Integer minfractionDigits, Integer maxfractionDigits)
	{
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "", " %", false);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link Number} is null then an empty {@link String}
	 * is returned.<p>
	 *
	 * <p>By default ' %' will be added as prefix.</p>
	 *
	 * <p>If the minimum number of fractional digits is null or lower then 0, the 0 is used. In the same spirit if the
	 * maximum number of fractional digits is null or below zero then the maximum is 340 (see {@link DecimalFormat#setMaximumFractionDigits(int)}).</p>
	 *
	 * @param number The number to format.
	 * @param minfractionDigits The minimum number of digits of the decimal separator.
	 * @param maxfractionDigits The maximum number of digits of the decimal separator.
	 *
	 * @see NumberUtils#basicFormat(DecimalNumber, Integer, Integer, String, String, boolean)
	 */
	public String format(DecimalNumber number, Integer minfractionDigits, Integer maxfractionDigits)
	{
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "", " %", false);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link Number} is null then an empty {@link String}
	 * is returned.</p>
	 *
	 * <p>By default ' %' will be added as prefix.</p>
	 *
	 * <p>If the minimum number of fractional digits is null or lower then 0, the 0 is used. In the same spirit if the
	 * maximum number of fractional digits is null or below zero then the maximum is 340 (see {@link DecimalFormat#setMaximumFractionDigits(int)}).</p>
	 *
	 * @param number The number to format.
	 * @param minfractionDigits The minimum number of digits of the decimal separator.
	 * @param maxfractionDigits The maximum number of digits of the decimal separator.
	 *
	 * @see NumberUtils#basicFormat(Number, Integer, Integer, String, String, boolean)
	 */
	public String format(Number number, Integer minfractionDigits, Integer maxfractionDigits)
	{
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "", " %", false);
	}

}

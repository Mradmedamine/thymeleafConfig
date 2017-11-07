package com.mainsys.fhome.gui.dialect.expression;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

import com.mainsys.fhome.gui.common.Constants;
import com.mainsys.fhome.gui.util.CurrencyUtils;
import com.mainsys.fhome.gui.util.NumberUtils;
import com.mainsys.fhome.module.base.model.core.CurrencyAmount;
import com.mainsys.fhome.module.base.model.core.DecimalNumber;

public class AmountExpressionObject
{

	/**
	 * Format CurrencyAmount with 0 scale
	 * @param amount
	 */
	public String formatCurrency(CurrencyAmount amount)
	{
		return CurrencyUtils.formatCurrencyAmount(amount, 0);
	}

	/**
	 * Format CurrencyAmount
	 *
	 * @param amount
	 * @param scale
	 */
	public String formatCurrency(CurrencyAmount amount, int scale)
	{
		return CurrencyUtils.formatCurrencyAmount(amount, scale);
	}

	/**
	 * Format BigDecimal to CurrencyAmount
	 */
	public String formatCurrency(BigDecimal amount)
	{
		return CurrencyUtils.formatCurrencyAmount(amount, 0);
	}

	public static String format(BigDecimal bigDecimal, int scale, boolean plusSign)
	{
		return CurrencyUtils.formatAmount(bigDecimal, scale, plusSign);
	}

	// NEW STRUCTURE

	// default formatters (max 2 digits after separator)

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link CurrencyAmount} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned. The formatted amount has
	 * 2 digits after the decimal separator.</p>
	 *
	 * <p>If {@link CurrencyAmount#getCurrencyCode()} is <i>EUR</i> then '€ ' will be added as prefix, otherwise currency
	 * code is added as suffix.</p>
	 *
	 * @param number The number to format.
	 *
	 * @see NumberUtils#basicFormat(CurrencyAmount, Integer, Integer, String, String, boolean)
	 */
	public String format(CurrencyAmount number)
	{
		if (StringUtils.equalsIgnoreCase(number.getCurrencyCode(), Constants.EURO_CURRENCY))
		{
			return NumberUtils.basicFormat(number, 2, 2, "€ ", "", false);
		}
		else if (number.getCurrencyCode().trim().length() == 3)
		{
			return NumberUtils.basicFormat(number, 2, 2, "", " " + number.getCurrencyCode().trim(), false);
		}
		else
		{
			return NumberUtils.basicFormat(number, 2, 2, "", "", false);
		}
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link DecimalNumber} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned. The formatted amount has
	 * 2 digits after the decimal separator.</p>
	 *
	 * <p>By default '€ ' will be added as prefix.</p>
	 *
	 * @param number The number to format.
	 *
	 * @see NumberUtils#basicFormat(DecimalNumber, Integer, Integer, String, String, boolean)
	 */
	public String format(DecimalNumber number)
	{
		return NumberUtils.basicFormat(number, 2, 2, "€ ", "", false);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link Number} is null then an empty {@link String}
	 * is returned. The formatted amount has 2 digits after the decimal separator.</p>
	 *
	 * <p>By default '€ ' will be added as prefix.</p>
	 *
	 * @param number The number to format.
	 *
	 * @see NumberUtils#basicFormat(Number, Integer, Integer, String, String, boolean)
	 */
	public String format(Number number)
	{
		return NumberUtils.basicFormat(number, 2, 2, "€ ", "", false);
	}

	// formatters with specific min and max number of digits after decimal separator

	/**
	 * <p>Return the formatted string of the <i>number</i>. If the {@link CurrencyAmount} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned.</p>
	 *
	 * <p>If {@link CurrencyAmount#getCurrencyCode()} is <i>EUR</i> then '€ ' will be added as prefix, otherwise currency
	 * code is added as suffix.</p>
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
		if (StringUtils.equalsIgnoreCase(number.getCurrencyCode(), Constants.EURO_CURRENCY))
		{
			return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "€ ", "", false);
		}
		else if (number.getCurrencyCode().trim().length() == 3)
		{
			return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "", " " + number.getCurrencyCode().trim(), false);
		}
		else
		{
			return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "", "", false);
		}
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link DecimalNumber} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned.</p>
	 *
	 * <p>By default '€ ' will be added as prefix.</p>
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
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "€ ", "", false);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link Number} is null then an empty {@link String}
	 * is returned.</p>
	 *
	 * <p>By default '€ ' will be added as prefix.</p>
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
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, "€ ", "", false);
	}

	// formatters with specific min and max number of digits after decimal separator and suffix and prefix and showSign

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link CurrencyAmount} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned.</p>
	 *
	 * <p>If the minimum number of fractional digits is null or lower then 0, the 0 is used. In the same spirit if the
	 * maximum number of fractional digits is null or below zero then the maximum is 340 (see {@link DecimalFormat#setMaximumFractionDigits(int)}).</p>
	 *
	 * @param number The number to format.
	 * @param minfractionDigits The minimum number of digits of the decimal separator.
	 * @param maxfractionDigits The maximum number of digits of the decimal separator.
	 * @param prefix The prefix to add to the formatted number.
	 * @param suffix The suffix to add to the formatted number.
	 * @param showSign If true, then the positive sign will also be shown.
	 *
	 * @see NumberUtils#basicFormat(CurrencyAmount, Integer, Integer, String, String, boolean)
	 */
	public String format(CurrencyAmount number, Integer minfractionDigits, Integer maxfractionDigits, String prefix, String suffix, boolean showSign)
	{
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, prefix, suffix, showSign);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link DecimalNumber} is null (or any internal
	 * fields representing the given number) then an empty {@link String} is returned.</p>
	 *
	 * <p>If the minimum number of fractional digits is null or lower then 0, the 0 is used. In the same spirit if the
	 * maximum number of fractional digits is null or below zero then the maximum is 340 (see {@link DecimalFormat#setMaximumFractionDigits(int)}).</p>
	 *
	 * @param number The number to format.
	 * @param minfractionDigits The minimum number of digits of the decimal separator.
	 * @param maxfractionDigits The maximum number of digits of the decimal separator.
	 * @param prefix The prefix to add to the formatted number.
	 * @param suffix The suffix to add to the formatted number.
	 * @param showSign If true, then the positive sign will also be shown.
	 *
	 * @see NumberUtils#basicFormat(DecimalNumber, Integer, Integer, String, String, boolean)
	 */
	public String format(DecimalNumber number, Integer minfractionDigits, Integer maxfractionDigits, String prefix, String suffix, boolean showSign)
	{
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, prefix, suffix, showSign);
	}

	/**
	 *	<p>Return the formatted string of the <i>number</i>. If the {@link Number} is null then an empty {@link String}
	 * is returned.</p>
	 *
	 * <p>If the minimum number of fractional digits is null or lower then 0, the 0 is used. In the same spirit if the
	 * maximum number of fractional digits is null or below zero then the maximum is 340 (see {@link DecimalFormat#setMaximumFractionDigits(int)}).</p>
	 *
	 * @param number The number to format.
	 * @param minfractionDigits The minimum number of digits of the decimal separator.
	 * @param maxfractionDigits The maximum number of digits of the decimal separator.
	 * @param prefix The prefix to add to the formatted number.
	 * @param suffix The suffix to add to the formatted number.
	 * @param showSign If true, then the positive sign will also be shown.
	 *
	 * @see NumberUtils#basicFormat(Number, Integer, Integer, String, String, boolean)
	 */
	public String format(Number number, Integer minfractionDigits, Integer maxfractionDigits, String prefix, String suffix, boolean showSign)
	{
		return NumberUtils.basicFormat(number, minfractionDigits, maxfractionDigits, prefix, suffix, showSign);
	}

}

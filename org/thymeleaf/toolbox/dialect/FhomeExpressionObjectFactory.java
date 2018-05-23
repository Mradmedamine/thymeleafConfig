package com.mainsys.fhome.gui.dialect;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import com.mainsys.enumeration.GenericValuedEnum;
import com.mainsys.fhome.gui.dialect.expression.AccountExpressionObject;
import com.mainsys.fhome.gui.dialect.expression.AddressExpressionObject;
import com.mainsys.fhome.gui.dialect.expression.AmountExpressionObject;
import com.mainsys.fhome.gui.dialect.expression.JodaExpressionObject;
import com.mainsys.fhome.gui.dialect.expression.LanguageExpressionObject;
import com.mainsys.fhome.gui.dialect.expression.NumberExpressionObject;
import com.mainsys.fhome.gui.dialect.expression.RateExpressionObject;

public class FhomeExpressionObjectFactory
	implements IExpressionObjectFactory
{

	public enum Expression implements GenericValuedEnum<String>
	{
		// @formatter:off
      RATE_EXPRESSION_OBJECT("rate"),
      JODA_EXPRESSION_OBJECT("joda"),
      NUMBER_EXPRESSION_OBJECT("number"),
      AMOUNT_EXPRESSION_OBJECT("amount"),
      LANGUAGE_EXPRESSION_OBJECT("lang"),
		ADDRESS_EXPRESSION_OBJECT("address"),
		ACCOUNT_EXPRESSION_OBJECT("account");
		// @formatter:on

		private final String value;

		private Expression(final String value)
		{
			this.value = value;
		}

		public static Expression fromValue(final String v)
		{
			for (Expression c : Expression.values())
			{
				if (StringUtils.equalsIgnoreCase(c.value, v))
				{
					return c;
				}
			}
			throw new IllegalArgumentException(v);
		}

		@Override
		public String getValue()
		{
			return value;
		}
	}

	private final Set<String> allExpressionObjectNames;

	{
		allExpressionObjectNames = new HashSet<String>();
		allExpressionObjectNames.add(Expression.AMOUNT_EXPRESSION_OBJECT.getValue());
		allExpressionObjectNames.add(Expression.RATE_EXPRESSION_OBJECT.getValue());
		allExpressionObjectNames.add(Expression.NUMBER_EXPRESSION_OBJECT.getValue());
		allExpressionObjectNames.add(Expression.JODA_EXPRESSION_OBJECT.getValue());
		allExpressionObjectNames.add(Expression.LANGUAGE_EXPRESSION_OBJECT.getValue());
		allExpressionObjectNames.add(Expression.ADDRESS_EXPRESSION_OBJECT.getValue());
		allExpressionObjectNames.add(Expression.ACCOUNT_EXPRESSION_OBJECT.getValue());
	}

	@Override
	public Object buildObject(IExpressionContext context, String expressionObjectName)
	{
		switch (Expression.fromValue(expressionObjectName))
		{
			case AMOUNT_EXPRESSION_OBJECT:
				return new AmountExpressionObject();
			case RATE_EXPRESSION_OBJECT:
				return new RateExpressionObject();
			case NUMBER_EXPRESSION_OBJECT:
				return new NumberExpressionObject();
			case JODA_EXPRESSION_OBJECT:
				return new JodaExpressionObject();
			case LANGUAGE_EXPRESSION_OBJECT:
				return new LanguageExpressionObject();
			case ADDRESS_EXPRESSION_OBJECT:
				return new AddressExpressionObject();
			case ACCOUNT_EXPRESSION_OBJECT:
				return new AccountExpressionObject();
			default:
				throw new IllegalArgumentException("No expression object found for name : " + expressionObjectName);
		}
	}

	/**
	 *  Always cache expression objects
	 */
	@Override
	public boolean isCacheable(String expressionObjectName)
	{
		return true;
	}

	@Override
	public Set<String> getAllExpressionObjectNames()
	{
		return allExpressionObjectNames;
	}
}

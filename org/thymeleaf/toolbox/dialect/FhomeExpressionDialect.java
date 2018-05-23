package com.mainsys.fhome.gui.dialect;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

public class FhomeExpressionDialect
	extends AbstractDialect
	implements IExpressionObjectDialect
{

	static final String DIALECT_NAME = "fhome";

	/**
	 * Constructor, initializes this dialect.
	 */
	public FhomeExpressionDialect()
	{
		super(DIALECT_NAME);
	}

	@Override
	public IExpressionObjectFactory getExpressionObjectFactory()
	{
		return new FhomeExpressionObjectFactory();
	}
}

package com.mainsys.fhome.gui.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import com.mainsys.fhome.gui.processor.AddressProcessor;
import com.mainsys.fhome.gui.processor.AmountProcessor;
import com.mainsys.fhome.gui.processor.BebanProcessor;
import com.mainsys.fhome.gui.processor.CommunicationProcessor;
import com.mainsys.fhome.gui.processor.CurrencyAmountProcessor;
import com.mainsys.fhome.gui.processor.IbanProcessor;
import com.mainsys.fhome.gui.processor.IndirectReferenceProcessor;
import com.mainsys.fhome.gui.processor.NumberProcessor;
import com.mainsys.fhome.gui.processor.RateProcessor;
import com.mainsys.fhome.gui.processor.SignDataProcessor;
import com.mainsys.fhome.gui.processor.SitecoreIframeProcessor;
import com.mainsys.fhome.gui.processor.SitecoreImageProcessor;
import com.mainsys.fhome.gui.processor.UrlPathParamProcessor;
import com.mainsys.fhome.gui.processor.ValidationResultMessageProcessor;
import com.mainsys.fhome.gui.processor.ValidationResultTagProcessor;

public class FhomeDialect
	implements IProcessorDialect
{

	@Override
	public String getPrefix()
	{
		return "fh";
	}

	@Override
	public String getName()
	{
		return "FhomeDialect";
	}

	@Override
	public int getDialectProcessorPrecedence()
	{
		return 1000;
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix)
	{
		final Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new AddressProcessor(dialectPrefix));
		processors.add(new BebanProcessor(dialectPrefix));
		processors.add(new CommunicationProcessor(dialectPrefix));
		processors.add(new CurrencyAmountProcessor(dialectPrefix));
		processors.add(new AmountProcessor(dialectPrefix));
		processors.add(new RateProcessor(dialectPrefix));
		processors.add(new NumberProcessor(dialectPrefix));
		processors.add(new IbanProcessor(dialectPrefix));
		processors.add(new IndirectReferenceProcessor(dialectPrefix));
		processors.add(new SignDataProcessor(dialectPrefix));
		processors.add(new SitecoreImageProcessor(dialectPrefix));
		processors.add(new SitecoreIframeProcessor(dialectPrefix));
		processors.add(new UrlPathParamProcessor(dialectPrefix));
		processors.add(new ValidationResultMessageProcessor(dialectPrefix));
		processors.add(new ValidationResultTagProcessor(dialectPrefix));
		return processors;
	}

}

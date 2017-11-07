package com.mainsys.fhome.gui.dialect.expression;

import java.util.Locale;
import java.util.Map;

import com.mainsys.fhome.gui.util.LanguageUtils;
import com.mainsys.fhome.module.base.model.core.Language;

public class LanguageExpressionObject
{

	public String localizedValue(Locale locale, Map<?, ?> map)
	{
		return LanguageUtils.getLocalizedValue(locale, map);
	}

	public String localizedValue(Language key, Map<?, ?> map)
	{
		return LanguageUtils.getLocalizedValue(key, map);
	}

	public String localizedValue(Locale locale, Map<?, ?> map, String fieldName)
	{
		return LanguageUtils.getLocalizedValue(locale, map, fieldName);
	}

	public String localizedValue(Language key, Map<?, ?> map, String fieldName)
	{
		return LanguageUtils.getLocalizedValue(key, map, fieldName);
	}

	public Language language(Locale locale)
	{
		return LanguageUtils.localeToLanguage(locale);
	}

}

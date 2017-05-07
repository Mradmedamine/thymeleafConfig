package com.thymeleafexamples.thymeleaf3.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IEngineContext;
import org.thymeleaf.context.IEngineContextFactory;
import org.thymeleaf.context.StandardEngineContextFactory;
import org.thymeleaf.engine.TemplateData;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.expression.ThymeleafEvaluationContext;
import org.thymeleaf.spring4.expression.ThymeleafEvaluationContextWrapper;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.springframework.expression.spel.support.StandardTypeLocator;

/**
 * Thymeleaf and Spring MVC configuration.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.thymeleafexamples")
public class ThymeleafConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

	private static final String UTF8 = "UTF-8";

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding(UTF8);
		return resolver;
	}

	private TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.setEngineContextFactory(engineContextFactory());
		return engine;
	}

	private IEngineContextFactory engineContextFactory() {
		return new CustomEngineContextFactory()
				// packages to register
				.registerImport("xxx.yyy")
				.registerImport("xxx.yyy.zzz");
	}

	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}

	public static class CustomEngineContextFactory implements IEngineContextFactory {

		private final IEngineContextFactory delegate;
		private final List<String> typeLocatorPrefixes;

		public CustomEngineContextFactory() {
			super();
			delegate = new StandardEngineContextFactory();
			typeLocatorPrefixes = new ArrayList<String>();
		}

		@Override
		public IEngineContext createEngineContext(IEngineConfiguration configuration, TemplateData templateData,
				Map<String, Object> templateResolutionAttributes, IContext context) {
			IEngineContext engineCtx = delegate.createEngineContext(configuration, templateData,
					templateResolutionAttributes, context);
			if (!engineCtx
					.containsVariable(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME)) {
				EvaluationContext evaluationContext = new StandardEvaluationContext();
				StandardTypeLocator typeLocator = (StandardTypeLocator) evaluationContext.getTypeLocator();
				for (String prefix : typeLocatorPrefixes) {
					typeLocator.registerImport(prefix);
				}
				engineCtx.setVariable(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME,
						new ThymeleafEvaluationContextWrapper(evaluationContext));
			}
			return engineCtx;
		}

		public CustomEngineContextFactory registerImport(String prefix) {
			typeLocatorPrefixes.add(prefix);
			return this;
		}
	}
}

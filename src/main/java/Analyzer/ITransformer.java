package Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;



public class ITransformer implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation,Class testclass,Constructor con,Method testMethod)
	{
	annotation.setRetryAnalyzer(retryAnalyzer.RetryAnalyzer.class);
	}
}

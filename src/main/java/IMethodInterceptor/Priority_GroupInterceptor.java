package IMethodInterceptor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Priority_GroupInterceptor  implements IMethodInterceptor {

	
	public List<IMethodInstance> intercept(List<IMethodInstance> methods,ITestContext context)
	{
		List<IMethodInstance> result=new ArrayList<IMethodInstance>();
		for(IMethodInstance method:methods)
		{
			Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
			Set<String> groups=new HashSet<String>();
			for(String group:testMethod.groups())
			{
				groups.add(group);
			}
			if(testMethod.priority()==1 && groups.contains("regression"))
			{
				result.add(method);
			}
		}
		return result;
		
	}

	
}

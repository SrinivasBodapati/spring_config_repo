package com.boa.kyc.configurations;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoDataTypeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		// TODO Auto-generated method stub
		String enabledDBType = System.getProperty("dbType");
		return (enabledDBType != null  && enabledDBType.equalsIgnoreCase("MONGODB"));
	}
	
	

}

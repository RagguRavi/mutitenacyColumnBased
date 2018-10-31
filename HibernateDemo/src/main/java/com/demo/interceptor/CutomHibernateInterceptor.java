package com.demo.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.demo.domain.TenantSupport;
import com.demo.util.TenantContext;

public class CutomHibernateInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("=================== onsave overrided ===============");
		if(entity instanceof TenantSupport) {
			((TenantSupport)entity).setTenantId(TenantContext.getCurrentTenant());
		}
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		System.out.println("=================== onFlushDirty overrided ===============");
		if(entity instanceof TenantSupport) {
			((TenantSupport)entity).setTenantId(TenantContext.getCurrentTenant());
		}
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}
}

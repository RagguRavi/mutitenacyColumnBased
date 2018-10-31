package com.demo.util;

import com.demo.util.TenantFI;;

public class Tenant {
	public static void doWithTenant(String tenantIdentifier, TenantFI tenantFI) {
		//Getting Current Tenant Identifier, which will be used to reset when Shared tenant execution is completed.
		String currentTenantIdentifier = TenantContext.getCurrentTenant();
		try {
			TenantContext.setCurrentTenant(tenantIdentifier);
			tenantFI.apply();
		} finally {
			TenantContext.setCurrentTenant(currentTenantIdentifier);
		}
	}
	
	public static void doWithoutTenant(TenantFI tenantFI) {
		//Getting Current Tenant Identifier, which will be used to reset when Shared tenant execution is completed.
		String currentTenantIdentifier = TenantContext.getCurrentTenant();
		try {
			TenantContext.setCurrentTenant(null);
			tenantFI.apply();
		} finally {
			TenantContext.setCurrentTenant(currentTenantIdentifier);
		}
	}
}

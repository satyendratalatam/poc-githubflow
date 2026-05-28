package com.poc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "features")
public class FeatureFlagConfig {

    private boolean customerSearchEnabled = false;
    private boolean paymentAuditEnabled = false;
    private boolean platformV2Enabled = false;

    public boolean isCustomerSearchEnabled() { return customerSearchEnabled; }
    public void setCustomerSearchEnabled(boolean customerSearchEnabled) { this.customerSearchEnabled = customerSearchEnabled; }

    public boolean isPaymentAuditEnabled() { return paymentAuditEnabled; }
    public void setPaymentAuditEnabled(boolean paymentAuditEnabled) { this.paymentAuditEnabled = paymentAuditEnabled; }

    public boolean isPlatformV2Enabled() { return platformV2Enabled; }
    public void setPlatformV2Enabled(boolean platformV2Enabled) { this.platformV2Enabled = platformV2Enabled; }
}

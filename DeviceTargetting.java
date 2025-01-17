package com.rungroup.web.models;

public class DeviceTargetting extends AdDecorator {
Advertisement ad;
String targetDevice;
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }
    public String showAdString(){
        return "Device targetted"+ad.showAdString();
    }
    public void setAd(){
        DecoratedAd=showAdString();
    }
    
}

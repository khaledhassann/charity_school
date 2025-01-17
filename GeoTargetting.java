package com.rungroup.web.models;

public class GeoTargetting extends AdDecorator {
Advertisement ad;
String targetLoc;
String UserLoc;
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }
    public String showAdString(){
        return "Geo"+ad.showAdString();
    }
    public void setAd(){
        DecoratedAd=showAdString();
    }
    
}

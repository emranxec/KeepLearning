package com.xec.JavaEight.company.fruitShop;

class FruitVendors {
    String vendorName;

    public FruitVendors(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return "vendorName='" + vendorName + '\'';
    }
}

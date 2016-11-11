package com.thomasjamesdev.thomas.grandetravel;

/**
 * Created by Thomas on 8/11/2016.
 */

public class Package {

    private String PackageTitle;
    private String PackageLocation;
    private String PackageDescription;
    private int PackagePrice;

    public Package(String title, String location, String description, int price) {
        this.PackagePrice = price;
        this.PackageDescription = description;
        this.PackageLocation = location;
        this.PackageTitle = title;
    }

    public String getPackageTitle() {
        return PackageTitle;
    }

    public void setPackageTitle(String packageTitle) {
        PackageTitle = packageTitle;
    }

    public int getPackagePrice() {
        return PackagePrice;
    }

    public void setPackagePrice(int packagePrice) {
        PackagePrice = packagePrice;
    }

    public String getPackageLocation() {
        return PackageLocation;
    }

    public void setPackageLocation(String packageLocation) {
        PackageLocation = packageLocation;
    }

    public String getPackageDescription() {
        return PackageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        PackageDescription = packageDescription;
    }

//    @Override
//    public String toString() {
//        return "Package{" +
//                "brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", features=" + Arrays.toString(features) +
//                ", price=" + price +
//                '}';
//    }

}

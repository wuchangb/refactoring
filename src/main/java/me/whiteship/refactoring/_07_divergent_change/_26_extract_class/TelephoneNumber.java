package me.whiteship.refactoring._07_divergent_change._26_extract_class;

public record TelephoneNumber(String areaCode, String officeNumber) {

    @Override
    public String toString() {
        return this.areaCode + " " + this.officeNumber;
    }
}
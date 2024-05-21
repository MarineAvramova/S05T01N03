package cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.dto;

public enum EUCountries {
    AUSTRIA,
    BELGIUM,
    BULGARIA,
    CROATIA,
    CYPRUS,
    CZECH_REPUBLIC,
    DENMARK,
    ESTONIA,
    FINLAND,
    FRANCE,
    GERMANY,
    GREECE,
    HUNGARY,
    IRELAND,
    ITALY,
    LATVIA,
    LITHUANIA,
    LUXEMBOURG,
    MALTA,
    NETHERLANDS,
    POLAND,
    PORTUGAL,
    ROMANIA,
    SLOVAKIA,
    SLOVENIA,
    SPAIN,
    SWEDEN;
    public static boolean isEUCountry(String country) {
        String normalizedCountry = country.toUpperCase().replace(" ", "_");
        for (EUCountries euCountry : EUCountries.values()) {
            if (euCountry.name().equals(normalizedCountry)) {
                return true;
            }
        }
        return false;
    }
}

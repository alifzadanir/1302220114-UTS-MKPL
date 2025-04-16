package lib;

public class PersonalData {
    private String name;
    private String address;
    private String idNumber;
    private boolean isForeigner;

    public PersonalData(String name, String address, String idNumber, boolean isForeigner) {
        this.name = name;
        this.address = address;
        this.idNumber = idNumber;
        this.isForeigner = isForeigner;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIdNumber() {
        return idNumber;
    }
    
}

/*Class digunakan untuk menyimpan data Keluarga untuk mengatasi big Class*/

package lib;

public class FamilyData{
    private int numberOfChildren;
    private String spouseName;

    public FamilyData(int numberOfChildren, String spouseName) {
        this.spouseName = spouseName;
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    public String getSpouseName() {
        return spouseName;
    }

}


package lib;

public class Employee {

    private String employeeId;
    private PersonalData personalData;
    private FamilyData familyData;
    private JoinDate joinDate;
    private int monthlySalary;
    private boolean isForeigner;
    private int annualDeductible;
	private int otherMonthlyIncome;

    public Employee(String employeeId, PersonalData personalData, FamilyData familyData, JoinDate joinDate) {
        this.employeeId = employeeId;
        this.personalData = personalData;
        this.familyData = familyData;
        this.joinDate = joinDate;
        this.isForeigner = personalData.isForeigner();
    }

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
     * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */
    public void setMonthlySalary(int grade) {
        switch (grade) {
            case 1:
                this.monthlySalary = 3000000;break;
            case 2:
                this.monthlySalary = 5000000;break;
            case 3:
                this.monthlySalary = 7000000;break;
            default:
                this.monthlySalary = 0;break;
        }

        if (isForeigner) {
            this.monthlySalary = (int) (this.monthlySalary * 1.5);
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

     public void setOtherMonthlyIncome(int otherIncome) {
        this.otherMonthlyIncome = otherIncome;
    }

    public int hitungAnnualTax() {
        int monthsWorked = 12;
        int currentYear = java.time.LocalDate.now().getYear();

        if (joinDate.getYear() == currentYear) {
            monthsWorked = 12; //contoh saja employee bergabung bulan 12
        }

        return TaxFunction.calculateTax(
            monthlySalary,
            otherMonthlyIncome,
            monthsWorked,
            annualDeductible,
            familyData.getSpouseName() != null,
            familyData.getNumberOfChildren()
        );
    }
}

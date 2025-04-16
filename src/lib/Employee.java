package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String PersonalData personalData;
	private String FamilyData familyData;
	private String JoinDate joinDate;
	private int monthlySalary;
	private int isForeigner;
	private int annualDeductible;
	
	public Employee(String employeeId, PersonalData personalData, FamilyData familyData, JoinDate joinDate) {
		this.employeeId = employeeId;
		this.personalData = personalData;
		this.familyData = familyData;
		this.joinDate = joinDate;
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(int grade) {	
		switch(grade){
			case 1: this.monthlySalary = 3000000;break;
			case 2: this.monthlySalary = 5000000;break;
			case 3: this.monthlySalary = 7000000;break;
		}
	}
	
		if (isForeigner){
			this.monthlySalary = (int)(this.monthlySalary * 1.5);
		}

	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	/*
	Fungsi digunakan untuk menghitung pajak tahunan berdasarkan faktor dibawah
	*/
	public int hitungAnnualTax() {
		return TaxFunction.calculateTax(
			monthlySalary, 
			joinDate.getYear(), 
			annualDeductible, 
			isForeigner, 
			familyData.getSpouseName() != null, 
			familyData.getNumberOfChildren());
	}
}

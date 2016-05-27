package pt.bucho.weather.entities;

import java.util.ArrayList;
import java.util.List;

public class ReportCollection extends Report {

	private List<Report> reports;
	
	public ReportCollection() {
		reports = new ArrayList<Report>();
	}
	
	public void addReport(Report report) {
		reports.add(report);
	}
	
	public Report getReport(int index) {
		return reports.get(index);
	}
	
	public List<Report> getReports() {
		return reports;
	}
	
}

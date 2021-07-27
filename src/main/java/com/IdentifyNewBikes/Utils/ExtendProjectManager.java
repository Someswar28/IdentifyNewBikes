package com.IdentifyNewBikes.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendProjectManager {
public static ExtentReports report;
	
   //Creating ExtendReport
	public static ExtentReports getInstance() {
		
		//Opening ExtendReport
		if(report==null) {
			ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\Report.html");
			report=new ExtentReports();
			report.attachReporter(htmlreporter);
			
			//Creating Enviroment Setup
			report.setSystemInfo("OS", "Windows10");
			report.setSystemInfo("Enviorment", "UTP");
			report.setSystemInfo("Built_number", "10.8.21");
			report.setSystemInfo("Browser", "Chrome");
			report.setSystemInfo("Tester_Name", "INTQEA21QE075-BATCH-5");
			
			//Creating UserInterface In Report
			htmlreporter.config().setDocumentTitle("UI Automation Report");
			htmlreporter.config().setReportName("Automation testing");
            htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlreporter.config().setTimeStampFormat("MMM-dd-yyyy,HH:mm:ss");
            htmlreporter.config().setTheme(Theme.DARK);
            
			
		}
		
		return report;
	}



}

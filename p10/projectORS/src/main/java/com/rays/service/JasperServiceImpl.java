package com.rays.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class JasperServiceImpl {

	public byte[] generateReport() throws JRException {
	    // Load the Jasper report template from a file or resource
		ResourceBundle rb = ResourceBundle.getBundle("application");
	    InputStream reportTemplate = getClass().getResourceAsStream(rb.getString("japser"));

	    // Compile the Jasper report template
	    JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);

	    // Create a data source from the report data
	    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(null);

	    // Set any additional parameters required by the report
	    Map<String, Object> parameters = new HashMap<>();
	    parameters.put("ReportTitle", "My Report");

	    // Generate the report
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

	    // Export the report to PDF format
	    byte[] reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);

	    return reportBytes;
	  }
}

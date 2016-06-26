package org.openup.izpack.validators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.izforge.izpack.api.data.InstallData;
import com.izforge.izpack.api.installer.DataValidator;

public class AdempiereSetupInstalationPanelDataValidator implements DataValidator{
	
	private static String OS = System.getProperty("os.name").toLowerCase();

	public final String ERROR_APPEMPTYSERVERADDRESS = "Enter a valid server address";
	public final String ERROR_APPWEBPORT = "The Web port must be a number between 1 and 65535";
	public final String ERROR_APPJNPPORT = "The JNP port must be a number between 1 and 65535";
	public final String ERROR_APPSSLPORT = "The SSL port must be a number between 1 and 65535";
	public final String ERROR_PGEMPTYSERVERADDRESS = "Enter a valid PostgreSQL address";
	public final String ERROR_PGPORT = "The postgresql port must be a number between 1 and 65535";
	public final String ERROR_PGEMPTYDB = "Enter a DB name";
	public final String ERROR_PGEMPTYADMINPASSWORD = "Enter a DB Admin Password";
	public final String ERROR_PGEMPTYADEMPIEREROLE = "Enter a DB Adempiere Role";
	public final String ERROR_PGEMPTYADEMPIEREPASSWORD = "Enter a DB Adempiere Password";
	
	private String retMsg;
	
	private String appServerAddress;
	private Integer appWebPort;
	private Integer appJnpPort;
	private Integer appSslPort;
	private String pgServerAddress;
	private String pgDbName;
	private Integer pgPort;
	private String pgAdminPassword;
	private String pgAdempiereRole;
	private String pgAdempierePassword;
	
	@Override
	public boolean getDefaultAnswer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getErrorMessageId() {
		// TODO Auto-generated method stub
		return retMsg;
	}

	@Override
	public String getWarningMessageId() {
		// TODO Auto-generated method stub
		return retMsg;
	}

	@Override
	public Status validateData(InstallData arg0) {
		
		System.out.println("Entra a validateData:");
		
//		System.out.println(arg0.getVariable("default.appserver.webPort"));
//		System.out.println(arg0.getVariable("default.appserver.jnpPort"));
//		System.out.println(arg0.getVariable("default.appserver.sslPort"));
//		System.out.println(arg0.getVariable("default.postgresql.psql"));
//		System.out.println(arg0.getVariable("default.postgresql.dbName"));
//		System.out.println(arg0.getVariable("default.postgresql.port"));
//		System.out.println(arg0.getVariable("default.postgresql.dbAdempiereRole"));
//		System.out.println("----");
//
//		System.out.println(arg0.getVariable("existing.appserver.webPort"));
//		System.out.println(arg0.getVariable("existing.appserver.jnpPort"));
//		System.out.println(arg0.getVariable("existing.appserver.sslPort"));
//		System.out.println(arg0.getVariable("existing.postgresql.home"));
//		System.out.println(arg0.getVariable("existing.postgresql.dbName"));
//		System.out.println(arg0.getVariable("existing.postgresql.port"));
//		System.out.println(arg0.getVariable("existing.postgresql.dbAdminPassword"));
//		System.out.println(arg0.getVariable("existing.postgresql.dbAdempiereRole"));
//		System.out.println(arg0.getVariable("existing.postgresql.dbAdempierePassword"));
//		
		

		if (arg0.getVariable("existing.appserver.serverAddress") != null && !arg0.getVariable("existing.appserver.serverAddress").equals("")) {
			appServerAddress = arg0.getVariable("existing.appserver.serverAddress");
		} else {
			this.retMsg = ERROR_APPEMPTYSERVERADDRESS;
			return Status.ERROR;
		}

		try {
			appWebPort = Integer.valueOf(arg0.getVariable("existing.appserver.webPort"));
			if (appWebPort < 1 || appWebPort > 65535) {
				this.retMsg = ERROR_APPWEBPORT;
				return Status.ERROR;
			}
		} catch (Exception e) {
			
			this.retMsg = ERROR_APPWEBPORT;
			return Status.ERROR;
		}
		
		try {
			appJnpPort = Integer.valueOf(arg0.getVariable("existing.appserver.jnpPort"));
			if (appJnpPort < 1 || appJnpPort > 65535) {
				this.retMsg = ERROR_APPJNPPORT;
				return Status.ERROR;
			}
		} catch (Exception e) {
			this.retMsg = ERROR_APPJNPPORT;
			return Status.ERROR;
		}

		try {
			appSslPort = Integer.valueOf(arg0.getVariable("existing.appserver.sslPort"));
			if (appSslPort < 1 || appSslPort > 65535) {
				this.retMsg = ERROR_APPSSLPORT;
				return Status.ERROR;
			}
		} catch (Exception e) {
			this.retMsg = ERROR_APPSSLPORT;
			return Status.ERROR;
		}

		if (arg0.getVariable("existing.postgresql.address") != null && !arg0.getVariable("existing.postgresql.address").equals("")) {
			pgServerAddress = arg0.getVariable("existing.postgresql.address");
		} else {
			
			this.retMsg = ERROR_PGEMPTYSERVERADDRESS;
			return Status.ERROR;
		}

		try {
			pgPort = Integer.valueOf(arg0.getVariable("existing.postgresql.port"));
			if (pgPort < 1 || pgPort > 65535) {
				this.retMsg = ERROR_PGPORT;
				return Status.ERROR;
			}
		} catch (Exception e) {
			this.retMsg = ERROR_PGPORT;
			return Status.ERROR;
		}
		
		if (arg0.getVariable("existing.postgresql.dbName") != null && !arg0.getVariable("existing.postgresql.dbName").equals("")) {
			pgDbName = arg0.getVariable("existing.postgresql.dbName");
		} else {
			this.retMsg = ERROR_PGEMPTYDB;
			return Status.ERROR;
		}

		if (arg0.getVariable("existing.postgresql.dbAdminPassword") != null && !arg0.getVariable("existing.postgresql.dbAdminPassword").equals("")) {
			pgAdminPassword = arg0.getVariable("existing.postgresql.dbAdminPassword");
		} else {
			this.retMsg = ERROR_PGEMPTYADMINPASSWORD;
			return Status.ERROR;
		}

		if (arg0.getVariable("existing.postgresql.dbAdempiereRole") != null && !arg0.getVariable("existing.postgresql.dbAdempiereRole").equals("")) {
			pgAdempiereRole = arg0.getVariable("existing.postgresql.dbAdempiereRole");
		} else {
			this.retMsg = ERROR_PGEMPTYADEMPIEREROLE;
			return Status.ERROR;
		}

		if (arg0.getVariable("existing.postgresql.dbAdempierePassword") != null && !arg0.getVariable("existing.postgresql.dbAdempierePassword").equals("")) {
			pgAdempierePassword = arg0.getVariable("existing.postgresql.dbAdempierePassword");
		} else {
			this.retMsg = ERROR_PGEMPTYADEMPIEREPASSWORD;
			return Status.ERROR;
		}
		
		
		System.out.println("INSTALL PATH ---->>>>> " + arg0.getVariable("INSTALL_PATH"));
		
		// Setting AdempiereEnv.properties
		
		File adempiereEnvTemplateFile = null;
		File adempiereEnvFile = null;
		
		FileReader adempiereEnvTemplateFr = null;
		FileWriter adempiereEnvFw = null;
		BufferedReader adempiereEnvTemplateBr = null;
        PrintWriter adempiereEnvPw = null;

        
		try {
			
			adempiereEnvTemplateFile = new File(arg0.getVariable("INSTALL_PATH") + File.separatorChar + "AdempiereEnvTemplate.properties");
			adempiereEnvTemplateFr = new FileReader(adempiereEnvTemplateFile);
			adempiereEnvTemplateBr = new BufferedReader(adempiereEnvTemplateFr);
			
			adempiereEnvFile = new File(arg0.getVariable("INSTALL_PATH") + File.separatorChar + "AdempiereEnv.properties");
            adempiereEnvFw = new FileWriter(adempiereEnvFile);
            adempiereEnvPw = new PrintWriter(adempiereEnvFw);
			
            // Building AdempiereEnv.properties
			String line;
			while ((line = adempiereEnvTemplateBr.readLine()) != null) {
				System.out.println(line);
				String var = getEnvTemplateVar(line);
				String settedVar = "";
			
				if (var.equalsIgnoreCase("JAVA_HOME")) {
						settedVar = "JAVA_HOME=" + arg0.getVariable("jdkPath");
				} else if (var.equalsIgnoreCase("ADEMPIERE_HOME")) {
						settedVar = "ADEMPIERE_HOME=" + arg0.getVariable("INSTALL_PATH");
				} else if (var.equalsIgnoreCase("ADEMPIERE_DB_TYPE")) {
					settedVar = "ADEMPIERE_DB_TYPE=" + "postgresql";
				} else if (var.equalsIgnoreCase("ADEMPIERE_DB_SERVER")) {
					settedVar = "ADEMPIERE_DB_SERVER=" + pgServerAddress;
				} else if (var.equalsIgnoreCase("ADEMPIERE_DB_PORT")) {
					settedVar = "ADEMPIERE_DB_PORT=" + pgPort;
				} else if (var.equalsIgnoreCase("ADEMPIERE_DB_NAME")) {
					settedVar = "ADEMPIERE_DB_NAME=" + pgDbName;
				} else if (var.equalsIgnoreCase("ADEMPIERE_DB_USER")) {
					settedVar = "ADEMPIERE_DB_USER=" + pgAdempiereRole;
				} else if (var.equalsIgnoreCase("ADEMPIERE_DB_PASSWORD")) {
					settedVar = "ADEMPIERE_DB_PASSWORD=" + pgAdempierePassword;
				} else if (var.equalsIgnoreCase("ADEMPIERE_APPS_SERVER")) {
					settedVar = "ADEMPIERE_APPS_SERVER=" + appServerAddress;
				} else if (var.equalsIgnoreCase("ADEMPIERE_JNP_PORT")) {
					settedVar = "ADEMPIERE_JNP_PORT=" + appJnpPort;
				} else if (var.equalsIgnoreCase("ADEMPIERE_WEB_PORT")) {
					settedVar = "ADEMPIERE_WEB_PORT=" + appWebPort;
				} else if (var.equalsIgnoreCase("ADEMPIERE_SSL_PORT")) {
					settedVar = "ADEMPIERE_SSL_PORT=" + appSslPort;
				} else if (var.equalsIgnoreCase("ADEMPIERE_KEYSTORE")) {
					settedVar = "ADEMPIERE_KEYSTORE=" + arg0.getVariable("INSTALL_PATH") + File.separatorChar + "myKeystore";
				} else {
					settedVar = line;
				}
				adempiereEnvPw.println(settedVar);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (adempiereEnvTemplateFr != null) {
					adempiereEnvTemplateFr.close();
				}
				if (adempiereEnvFw != null) {
					adempiereEnvFw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		// Launching Adempiere Setup
		
//		System.out.println("Es Linux: " + isUnix());
//		System.out.println("Es Windows:" + isWindows());
		
//		if (isUnix()) {
//			try {
//				ProcessBuilder pbuilder;
//				
//				pbuilder = new ProcessBuilder(arg0.getVariable("INSTALL_PATH") + File.separatorChar + "RUN_silentsetup.sh");
//				pbuilder.start();
//				
//				pbuilder = new ProcessBuilder(arg0.getVariable("INSTALL_PATH") + File.separatorChar + "utils" + File.separatorChar + "RUN_silentsetup.sh");
//				pbuilder.start();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else if (isWindows()) {
//	        try {
//				ProcessBuilder pbuilder;
//				
//				pbuilder = new ProcessBuilder(arg0.getVariable("INSTALL_PATH") + File.separatorChar + "RUN_silentsetup.bat");
//				pbuilder.start();
//				
//				pbuilder = new ProcessBuilder(arg0.getVariable("INSTALL_PATH") + File.separatorChar + "utils" + File.separatorChar + "RUN_silentsetup.bat");
//				pbuilder.start();
//
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
//		ProcessBuilder pbuilder = new ProcessBuilder( "pg_restore", "-i", "-h", appServerAddress, "-p", pgPort, "-U", pgAdempiereRole, "-d", pgDbName, "-v", path );
		
		
		// Launching Adempiere Import
		
		
		
		
		retMsg = "Successful Installation";
		
		return Status.OK;
	}
	
	private String getEnvTemplateVar(String line) {
		String ret = "";
		
		try {
			if (line.toCharArray()[0] != '#') {
				ret = line.split("=")[0];
			}
		} catch (Exception e) {
			
		}
		
		return ret;
	}
	
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );		
	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}
	

}

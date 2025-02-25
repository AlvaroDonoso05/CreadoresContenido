package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import Views.MainView;

public class Logger {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
	public static final String ANSI_BRIGHT_RED = "\u001B[91m";
	public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
	public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
	public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
	public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
	public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
	public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";

	private Properties properties;
	private FileWriter fw;
	private File logFile;
	private MainView view;

	private static Logger instance;

	public static Logger getInstance() {
		if(instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	private Logger() {
		try {
			this.properties = new Properties();
			InputStream input = new FileInputStream("resources/config.properties");
			this.properties.load(input);
		} catch (Exception e) {
			this.error(e);
		}
	}

	private void loggerFile(String texto) {
		logFile = new File("resources/logs.txt");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		try {
			LocalDateTime now = LocalDateTime.now();
			fw = new FileWriter(logFile, true);
			fw.write(now.format(formatter) + " " + texto + "\n");
		} catch (Exception e) {
			this.error(e);
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				this.error(e);
			}
		}
	}

	public void warning(String texto) {
		System.out.println(ANSI_YELLOW + "[WARN] " + ANSI_BRIGHT_YELLOW + texto);
		mostrarUsuario("[WARN] " + texto);
		loggerFile("[WARN] " + texto);
	}

	public void error(Exception e) {

		if (!Boolean.parseBoolean(properties.getProperty("console.debug"))) {
			System.out.println(ANSI_RED + "[ERROR] " + ANSI_BRIGHT_RED + e);
			mostrarUsuario("[ERROR] " + e);
		} else {
			e.printStackTrace();
		}
		loggerFile("[ERROR] " + e);
	}

	public void log(String texto) {
		System.out.println(ANSI_BLUE + "[LOGGER] " + ANSI_BRIGHT_BLUE + texto);
		mostrarUsuario("[LOGGER] " + texto);
		loggerFile("[LOGGER] " + texto);
	}

	public void success(String texto) {
		System.out.println(ANSI_GREEN + "[SUCCESS] " + ANSI_BRIGHT_GREEN + texto);
		mostrarUsuario("[SUCCESS] " + texto);
		loggerFile("[SUCCESS] " + texto);
	}

	public void mostrarUsuario(String text) {
		this.view.textAreaLogger.append(text + "\n");
	}

	public void setView(MainView view) {
		this.view = view;
	}

}

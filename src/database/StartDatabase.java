package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.concurrent.TimeoutException;

public class StartDatabase {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			String url = "jdbc:hsqldb:hsql://localhost";
			try {
				connection = DriverManager.getConnection(url, "sa", "");
			} catch (SQLTransientConnectionException e) {
				startDatabaseServer();
			}
		
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			connection = DriverManager.getConnection(url, "sa", "");
			connection.setAutoCommit(false);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {} 
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
	}

	private static void startDatabaseServer() {
		// РїР°СЂР°РјРµС‚СЂС‹ РґР»СЏ Р·Р°РїСѓСЃРєР°
		String cmd[] = { "cmd.exe", "/C", "start", "runServer.bat" };

		try {
			executeCommandLine(cmd, true, true, 10000L);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

	public static int executeCommandLine(final String[] commandLine,
			final boolean printOutput, final boolean printError,
			final long timeout) throws IOException, InterruptedException,
			TimeoutException {

		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(commandLine);
		Worker worker = new Worker(process);
		worker.start();
		try {
			worker.join(timeout);
			if (worker.exit != null)
				return worker.exit;
			else
				throw new TimeoutException();
		} catch (InterruptedException ex) {
			worker.interrupt();
			Thread.currentThread().interrupt();
			throw ex;
		} finally {
			process.destroy();
		}
	}

	private static class Worker extends Thread {
		private final Process process;
		private Integer exit;

		private Worker(Process process) {
			this.process = process;
		}

		public void run() {
			try {
				exit = process.waitFor();
			} catch (InterruptedException ignore) {
				return;
			}
		}
	}
}

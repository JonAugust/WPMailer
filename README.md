**WPMailer**

WP Mailer is a utility that checks a database for queued email messages and then sends them using MailGun.

These are the required jars:
- commons-dbcp2-2.2.0.jar
- commons-io-2.6.jar
- commons-logging-1.2.jar
- commons-pool2-2.5.0.jar
- httpasyncclient-4.0.1.jar
- httpclient-4.5.5.jar
- httpcore-4.4.9.jar
- httpcore-nio-4.3.2.jar
- httpmime-4.5.5.jar
- json-20140107.jar
- mysql-connector-java-5.1.46-bin.jar
- unirest-java-1.4.9.jar

com.washpress.mail.Credentials.java has the following class variables and associated getters:

    private static final String mailgunAPIKey = "XXXXXX";
    private static final String dbUser = "XXXXXX";
    private static final String dbPass = "XXXXXX";
    private static final String dbName = "XXXXXX";
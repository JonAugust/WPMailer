package com.washpress.mail;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class WPMailer {

    private static final String _myDomain = "mg.washpress.com";

    public static void main(String[] args) {
        Connection connect = null;
        ResultSet rs;
        Statement st;
        PreparedStatement ps;
        String query;

        try {
            connect = DataSource.getInstance().getConnection();

            query = "SELECT * FROM email_queue";
            ps = connect.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int messageID = rs.getInt("id");
                String recipientEmail = rs.getString("recipient_email");
                String senderEmail = rs.getString("sender_email");
                String subject = rs.getString("subject");
                String body = rs.getString("body");
                System.out.println(messageID + " - " + recipientEmail);

                HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + _myDomain + "/messages")
                        .basicAuth("api", Credentials.getMailgunAPIKey())
                        .field("from", senderEmail)
                        .field("to", recipientEmail)
                        .field("subject", subject)
                        .field("html", body)
                        .asJson();

                // TODO Add error handling.
                if (request.getStatus() == 200) {
                   st = connect.createStatement();
                   st.executeUpdate("delete from email_queue where id=" + messageID);
                }

            }

            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

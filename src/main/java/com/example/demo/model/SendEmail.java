package com.example.demo.model;

public class SendEmail {
    private final String destinationAddress;
    private final String subject;
    private final String emailBody;

    public SendEmail(String destinationAddress, String subject, String emailBody) {
        this.destinationAddress = destinationAddress;
        this.subject = subject;
        this.emailBody = emailBody;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailBody() {
        return emailBody;
    }
}

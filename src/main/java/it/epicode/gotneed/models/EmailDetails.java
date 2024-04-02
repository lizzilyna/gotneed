package it.epicode.gotneed.models;

public class EmailDetails {

    private String recipient; // Indirizzo email del destinatario
    private String subject; // Oggetto dell'email
    private String message; // Corpo del messaggio

    // Costruttore vuoto
    public EmailDetails() {
    }

    // Costruttore con tutti i parametri
    public EmailDetails(String recipient, String subject, String message) {
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
    }

    // Getter e Setter
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "EmailDetails{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
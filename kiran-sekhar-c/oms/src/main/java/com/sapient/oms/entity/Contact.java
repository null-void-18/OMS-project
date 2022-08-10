package com.sapient.oms.entity;

public class Contact {
    
    private String email;
    private String primaryContact; // primary cell no.
    private String secondaryContact; // secondary cell no. , can be null
    
    public Contact(String email, String primaryContact, String secondaryContact) {
        this.email = email;
        this.primaryContact = primaryContact;
        this.secondaryContact = secondaryContact;

        // System.out.println(this.email+" "+this.primaryContact+" "+this.secondaryContact);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[ Email:- "+this.email+", PrimaryCell:- "+this.primaryContact+", Secondary Cell:- "+(secondaryContact==null?"NA":this.secondaryContact)+" ]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getSecondaryContact() {
        return secondaryContact;
    }

    public void setSecondaryContact(String secondaryContact) {
        this.secondaryContact = secondaryContact;
    }
    

}

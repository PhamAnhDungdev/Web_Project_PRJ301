
package Model;

import java.util.Date;


public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private String email;
    private String username;
    private String password;
    private int role;
    private Date registration;
    
    public User(){}

    public User(int id, String firstname, String lastname, String phone, String address, String email, String username, String password, int role, Date registration) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registration = registration;
    }
    
    public User( String firstname, String lastname, String phone, String address,String email, String username, String password, int role, Date registration) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registration = registration;
    }

    public User(String firstname, String lastname, String phone, String address, String email, String username, String password, int role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "User{" + "firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", address=" + address + ", email=" + email + ", username=" + username + ", password=" + password + ", role=" + role + ", registration=" + registration + '}';
    }

    

    
    
}

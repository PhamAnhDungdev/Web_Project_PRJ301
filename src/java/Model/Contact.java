
package Model;

public class Contact {
    private int Id;
    private String Name;
    private String Title;
    private String Email;
    private String Message;
    
    public Contact(){}
    
    public Contact(int Id, String Name, String Title, String Email, String Message) {
        this.Id = Id;
        this.Name = Name;
        this.Title = Title;
        this.Email = Email;
        this.Message = Message;
    }

    public Contact(String Name, String Title, String Email, String Message) {
        this.Name = Name;
        this.Title = Title;
        this.Email = Email;
        this.Message = Message;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "Contact{" + "Id=" + Id + ", Name=" + Name + ", Title=" + Title + ", Email=" + Email + ", Message=" + Message + '}';
    }
}

package Bean;

public class Member {
    private String uname, password, email, phone;

    private String money,isBlocked, numberOrders;

    public Member(String uname, String phone,  String email, String isBlocked, String money, String numberOrders) {
        this.uname = uname;
        this.isBlocked = isBlocked;
        this.email = email;
        this.phone = phone;
        this.money = money;
        this.numberOrders = numberOrders;
    }

    public Member(String uname, String email, String phone) {
        this.uname = uname;
        this.email = email;
        this.phone = phone;
    }


    public Member(String uname,  String password, String email, String phone) {
        this.uname = uname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
//    public Member(String uname, String email, String phone, String password) {
//        this.uname = uname;
//        this.password = password;
//        this.email = email;
//        this.phone = phone;
//    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberOrders() {
        return numberOrders;
    }

    public void setNumberOrders(String numberOrders) {
        this.numberOrders = numberOrders;
    }

    public String getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(String isBlocked) {
        this.isBlocked = isBlocked;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Member{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", money='" + money + '\'' +
                ", isBlocked='" + isBlocked + '\'' +
                ", numberOrders='" + numberOrders + '\'' +
                '}';
    }
}

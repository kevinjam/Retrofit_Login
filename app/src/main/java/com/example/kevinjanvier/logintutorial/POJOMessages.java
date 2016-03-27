package com.example.kevinjanvier.logintutorial;

/**
 * Created by kevinjanvier on 24/03/16.
 */
import android.os.Parcel;
import android.os.Parcelable;
public class POJOMessages implements Parcelable{

    private int code;
    private String message;
    private String name;
    private Object id_user;
    private String email;


    protected POJOMessages(Parcel in) {
        code = in.readInt();
        message = in.readString();
        name = in.readString();
        email = in.readString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getId_user() {
        return id_user;
    }

    public void setId_user(Object id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Creator<POJOMessages> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<POJOMessages> CREATOR = new Creator<POJOMessages>() {
        @Override
        public POJOMessages createFromParcel(Parcel in) {
            return new POJOMessages(in);
        }

        @Override
        public POJOMessages[] newArray(int size) {
            return new POJOMessages[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(message);
        dest.writeString(name);
        dest.writeString(email);
    }
}

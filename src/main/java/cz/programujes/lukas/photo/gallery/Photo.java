package cz.programujes.lukas.photo.gallery;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;

    //variable + a rule for validation (not empty)
    @NotEmpty
    private String fileName;

    //raw data
    private byte[] data;

    //2 constructors, overloading
    public Photo() {
    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

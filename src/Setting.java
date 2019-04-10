
// каждый обьект из класса Setting - содержит пару (ключ-значение)
// напр Setting audio = new Setting("volume","70");
// напр Setting video = new Setting("video_format","mp4");
// дополнить класс тем что требуется внутри


import java.io.Serializable;

public class Setting implements Serializable {
    private static final long serialVersionUID = 1;
    private String name;
    private String value;

    public Setting(String name, String value) {
        setName(name);
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  "\n" + " name: " + name + "," +
                " value: " + value
                ;
    }
}
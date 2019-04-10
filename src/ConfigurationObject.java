////////////////////////////
// каждый обьект из класса ConfigurationObject - содержит набор настроек
// это благодаря ArrayList<Setting> тоесть коллекция обьектов настроек


import java.io.*;
import java.util.ArrayList;

class ConfigurationObject implements Serializable {
    private static final long serialVersionUID = 11;
    private String name;
    private ArrayList<Setting> settings;
    // +constructor() + set()/get() + toString()


    public ConfigurationObject(String name, ArrayList settings) {
        setName(name);
        setSettings(settings);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Setting> getSettings() {
        return settings;
    }
    public void setSettings(ArrayList<Setting> settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "ConfigurationObject{" +
                "name: " + name + "\n" +
                "settings: " + settings + "\n";
    }

    public void addSetting(Setting setting){
        // добавляет обьект настройки в список
        this.settings.add(setting);
        
    }
    public Setting getSetting(String key){
        // находит обьект настройки по ключу
        Setting finded = null;
        for ( Setting object : settings)
        {
            if( key.equals( object.getValue() ) ){
                finded = object;
                break;
            }
        } return finded;
    }
    public void removeSetting(String key) {
        // УДАЛЯЕТ обьект настройки по ключу
        Setting finded = null;
        for (Setting object : settings) {
            if (key.equals(object.getValue())) {
                settings.remove(object);
                break;
            }
        }
    }

    public static void saveConfiguration(ConfigurationObject config) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("./config/product", true)  // <-- network
        );
        oos.writeObject(config);
        oos.close();
    }
    public static ConfigurationObject loadConfiguration() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("./config/product")  // <-- network
        );
        ConfigurationObject config = (ConfigurationObject) ois.readObject();

        return config;
    }
}

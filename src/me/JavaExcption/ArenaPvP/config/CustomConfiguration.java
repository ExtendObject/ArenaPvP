package me.JavaExcption.ArenaPvP.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.representer.Representer;

import java.lang.reflect.Field;
import java.util.*;

public class CustomConfiguration extends YamlConfiguration{
    private UUID toread = null;
    private int lines = 0;

    public CustomConfiguration(UUID toread,int lines){
        this.toread = toread;
        this.lines = lines;
    }

    public CustomConfiguration(){
    }

    private static Object get(CustomConfiguration c,String s){
        try {
            Field field = c.getClass().getField(s);
            return field.get(c);
        } catch (Exception e) {
            return null;
        }
    }


    protected Yaml getYaml(){
        return (Yaml)get(this,"yaml");
    }

    protected DumperOptions getOptionsDump(){
        return (DumperOptions)get(this,"yamlOptions");
    }

    protected Representer getRepresenter(){
        return (Representer)get(this,"yamlRepresenter");
    }


    @Override
    public String saveToString() {
        this.getOptionsDump().setIndent(this.options().indent());
        this.getOptionsDump().setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        this.getOptionsDump().setAllowUnicode(SYSTEM_UTF);
        this.getRepresenter().setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        String dump = this.getYaml().dump(this.getValues(false));
        if(dump.equals("{}\n")) {
            dump = "";
        }
        for(int i = 0;i < lines;i ++){
            dump = dump.replace(toread.toString() + "-" + String.valueOf(i) + ":","#");
        }
        return dump;
    }

    @Override
    public void loadFromString(String contents) throws InvalidConfigurationException {
        if(contents == null)throw new IllegalArgumentException("Contents cannot be null");
        boolean commentline = false;
        if(toread == null)toread = UUID.randomUUID();
        String newcontents = "";
        for(Character c:contents.toCharArray()){
            if(c.equals('\n') || c.equals('\r')){
                commentline = false;
            }
            else if(!commentline && c.equals('#')){
                newcontents += toread.toString() + "-" + String.valueOf(lines) + ":";
                lines++;
                commentline = true;
                continue;
            }
            newcontents += String.valueOf(c);
        }

        Map input;
        try {
            input = (Map)this.getYaml().load(newcontents);
        } catch (YAMLException var4) {
            throw new InvalidConfigurationException(var4);
        } catch (ClassCastException var5) {
            throw new InvalidConfigurationException("Top level is not a Map.");
        }

        if(input != null) {
            this.convertMapsToSections(input, this);
        }
    }
}

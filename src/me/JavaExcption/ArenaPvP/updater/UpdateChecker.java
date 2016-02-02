package me.JavaExcption.ArenaPvP.updater;

import me.JavaExcption.ArenaPvP.ArenaPvP;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Henry on 2/2/2016.
 */
public class UpdateChecker {

    private ArenaPvP plugin;
    private URL filesFeed;

    private String version, link;

    public UpdateChecker(ArenaPvP plugin, String url) {
        this.plugin = plugin;

        try {
            this.filesFeed = new URL(url);
        } catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateNeeded() {
        try {
            InputStream inputStream = this.filesFeed.openConnection().getInputStream();
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            Node latestFile = document.getElementsByTagName("item").item(0);
            NodeList children = latestFile.getChildNodes();

            this.version = children.item(1).getTextContent().replaceAll("[a-zA-Z ]", "");
            this.link = children.item(3).getTextContent();

            if(!plugin.getDescription().getVersion().equals(this.version)) {
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getVersion() {
        return version;
    }

    public String getLink() {
        return link;
    }
}

package net.cubespace.dynmap.multiserver.Config;


import net.cubespace.Yamler.Config.Comment;
import net.cubespace.Yamler.Config.Config;

import java.io.File;
import java.util.ArrayList;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 */
public class Main extends Config {
    public Main() {
        CONFIG_FILE = new File("config/main.yml");

        DynMap.add(new Dynmap());
    }

    public String Webserver_IP = "0.0.0.0";
    public Integer Webserver_Port = 8080;
    public String Webserver_webDir = "web/";
    public String Webserver_Title = "Awesome Multiserver Dynmap";
    public Integer Webserver_WorkerThreads = 16;
    public String Webserver_DefaultWorld = "world";
    public String Webserver_DefaultMap = "flat";
    public Integer Webserver_DefaultZoom = 2;
    @Comment("Set SidebarOpened: 'true' to pin menu sidebar opened permanently, 'pinned' to default the sidebar to pinned, but allow it to unpin")
    public String Webserver_SidebarOpened = "false";

    public ArrayList<Dynmap> DynMap = new ArrayList<>();

}

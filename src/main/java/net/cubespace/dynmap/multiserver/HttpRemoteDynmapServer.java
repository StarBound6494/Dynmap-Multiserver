package net.cubespace.dynmap.multiserver;

import net.cubespace.dynmap.multiserver.Config.Dynmap;
import net.cubespace.dynmap.multiserver.util.AbstractFile;
import net.cubespace.dynmap.multiserver.util.HttpRemoteFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author geNAZt (fabian.fassbender42@googlemail.com)
 */
public class HttpRemoteDynmapServer extends AbstractDynmapServer {
    static Logger logger = LoggerFactory.getLogger(HttpRemoteDynmapServer.class);
    private final String url;

    public HttpRemoteDynmapServer(Dynmap config) {
        super(config);
        if (config.Url.endsWith("/")) {
            this.url = config.Url;
        } else {
            this.url = config.Url + "/";
        }
    }

    @Override
    public AbstractFile getFile(String path) throws IOException {
        path = path.replace(File.separator, "/");
        String remoteUrl;

        if (path.startsWith("/")) {
          remoteUrl = url + path.substring(1);
        } else {
          remoteUrl = url + path;
        }

        logger.info(path + " --> " + remoteUrl);
        return new HttpRemoteFile(remoteUrl);
    }
}

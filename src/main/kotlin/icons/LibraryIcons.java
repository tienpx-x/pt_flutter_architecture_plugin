package icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public class LibraryIcons {
    private static Icon load(String path) {
        return IconLoader.getIcon(path, LibraryIcons.class);
    }

    public static final Icon PT_ROOT_GROUP = load("/icons/root_group.png");
}
package P03_GraphicEditor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Drawable> drawables = new ArrayList<>() {{
            add(new Circle());
            add(new Rectangle());
        }};

        GraphicEditor graphicEditor = new GraphicEditor();

        for (Drawable drawable : drawables) {
            graphicEditor.drawShape(drawable);
        }
    }
}
